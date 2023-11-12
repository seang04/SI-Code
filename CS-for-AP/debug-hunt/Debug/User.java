package Debug;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class User extends Thread
{
    private Server server;
    private Socket socket;
    DataInputStream in;
    private String username;

    User(Server server)
    {
        this.server = server;
    }

    @Override
    public void run()
    {
        try
        {
            socket = server.getServerSocket().accept();
            User newUser = new User(server);
            server.addUser(newUser);
            newUser.start();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            username = in.readUTF();
            System.out.println(this + " connected.");
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }

    public void writeTo(String message) throws IOException
    {
        DataOutputStream out;
        out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(message);
    }

    public String getUsername()
    {
        return this.username;
    }

    @Override
    public String toString()
    {
        return username + "@" + socket.getInetAddress() + ":" + socket.getPort();
    }


}