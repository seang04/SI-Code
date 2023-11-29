package Debug;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private Socket socket;
    private BufferedReader user_in = new BufferedReader(new InputStreamReader(System.in));
    private DataInputStream server_input;
    private DataOutputStream out;
    private List<String> messages = new ArrayList<>();

    public Client(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Enter username: ");
            String username = user_in.readLine();
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(username);
            server_input = new DataInputStream(socket.getInputStream());
            String message = server_input.readUTF();
            while(!message.equals("kill"))
            {
                messages.add(message);
            }

        }
        catch (UnknownHostException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        Client client = new Client("seanlaptop.student.rit.edu", 5001);
    }

}
