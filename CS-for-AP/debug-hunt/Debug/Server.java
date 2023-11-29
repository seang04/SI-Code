package Debug;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;
    private List<User> users;
    private int num_users = 0;

    public Server(int port)
    {
        users = new ArrayList<>();
        try
        {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            users.add(new User(this));
            users.get(0).start();
        }

        catch (IOException e)
        {
            System.err.println(e);
        }
    }

    public boolean send(String user, String message)
    {
        for(User i : users.subList(0, users.size() - 1))
        {
            if(i.getUsername() != null && i.getUsername().equals(user))
            {
                try {
                    i.writeTo(message);
                }
                catch(IOException e)
                {
                    System.err.println(e);
                    users.remove(i);
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers()
    {
        return this.users.subList(0, num_users);
    }

    public void addUser(User user)
    {
        users.add(user);
        num_users++;
    }

    public ServerSocket getServerSocket()
    {
        return serverSocket;
    }

    public static void main(String[] args)
    {
        Server server = new Server(5001);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String line = in.readLine();
            while(!line.equals("/exit"))
            {
                Scanner scanner = new Scanner(line);
                String command = scanner.next();
                if(command.equals("send"))
                {
                    boolean sent = server.send(scanner.next(), scanner.next());
                    if(!sent) System.out.println("Message not sent.");
                }
                if(command.equals("list"))
                {
                    System.out.println(server.getUsers());
                }
                line = in.readLine();
            }
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }


}