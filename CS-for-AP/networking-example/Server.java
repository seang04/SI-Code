import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket; 
    private DataInputStream in; 
    private List<Socket> connections; 

    public Server(int port)
    {
        connections = new LinkedList<>();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            User user = new User(this);
            user.start();
        }
 
        catch (IOException i) {
 
            System.out.println(i);
        }
    }

    public Socket accept() throws IOException
    {
        Socket socket = serverSocket.accept();
        connections.add(socket); 
        return socket;
    }

    synchronized public void messageConnections(ServerMessage msg)
    {
        DataOutputStream out; 
        for(Socket socket : connections)
        {
            if(msg.checkSameUser(socket)) continue; 
            try
            {
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(msg.toString());
            }
            catch(IOException e)
            {
                connections.remove(socket);
                try
                {
                    socket.close();
                }
                catch(IOException ex)
                {
                    System.err.println(e);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
 
        Server server = new Server(5000);
        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
        try 
        { 
            String line = consoleIn.readLine(); 
            while(!line.equals("/exit"))
            {
                ServerMessage msg = new ServerMessage(null, line);
                server.messageConnections(msg);
                line = consoleIn.readLine();
            }
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
}
