import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

class InputHandler extends Thread{

    BufferedReader input; 
    DataOutputStream output; 
    InputHandler(BufferedReader input, DataOutputStream output)
    {
        this.input = input; 
        this.output = output; 
    }

    @Override
    public void run() {
        String line = ""; 
        while(!line.equals("/exit"))
        {
            try
            {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch(IOException e)
            {
                System.err.println(e);
            }
        }
    }
}

public class ClientSide {
    // initialize socket and input output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataInputStream server_input; 
    private DataOutputStream out = null;
 
    // constructor to put ip address and port
    public ClientSide(String address, int port)
    {
 
        // establish a connection
        try {
 
            socket = new Socket(address, port);
 
            System.out.println("Connected");

            InputHandler inputHandler = new InputHandler(new BufferedReader(new InputStreamReader(System.in)), new DataOutputStream(socket.getOutputStream())); 
            inputHandler.start();
 
            server_input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        }
 
        catch (UnknownHostException u) {
 
            System.out.println(u);
        }
 
        catch (IOException i) {
 
            System.out.println(i);
        }
 
        // string to read message from input
        String line = "";
        String server_line = "";
        // keep reading until "End" is input
        while (!line.equals("End")) {
 
            try {
                server_line = server_input.readUTF();
                System.out.println(server_line);
            }
 
            catch (IOException i) {
 
                System.out.println(i);
            }
        }
 
        // close the connection
        try {
 
            input.close();
 
            out.close();
 
            socket.close();
        }
 
        catch (IOException i) {
 
            System.out.println(i);
        }
    }
 
    public static void main(String[] args)
    {
 
        ClientSide client
            = new ClientSide("127.0.0.1", 5000);
    }
}

