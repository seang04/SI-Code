import java.net.Socket;

public class ServerMessage {
    Socket user; 
    String message; 
    ServerMessage(Socket user, String message)
    {
        this.user = user;
        this.message = message;
    }
    @Override
    public String toString()
    {
        return "[" + user.getInetAddress() + ":" + user.getPort() + "]" + message; 
    }

    public boolean checkSameUser(Socket other)
    {
        return user.equals(other); 
    }
}
