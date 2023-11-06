import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class User extends Thread{
    private Socket socket; 
    DataInputStream in;
    private String username;
    static private Server server;
    static private int number_users = 0;

    User()
    {
        number_users++;
    }
    User(Server server)
    {
        User.server = server; 
        number_users++;
    }

    @Override
    public void run()
    {
        try 
        {
            socket = server.accept();
            this.username = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
            System.out.println(username + " connected.");
            new User().start();
            
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while(!line.equals("/exit"))
            {
                line = in.readUTF();
                ServerMessage message = new ServerMessage(socket, line);
                System.out.println(message);
                server.messageConnections(message);
            }

        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
}
