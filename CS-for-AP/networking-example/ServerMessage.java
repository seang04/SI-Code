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
        if(this.user == null) return "[ADMIN] " + message; 
        return "[" + user.getInetAddress() + ":" + user.getPort() + "] " + message; 
    }

    public boolean checkSameUser(Socket other)
    {
        if(other == null || user == null) return user == other; 
        return user.equals(other); 
    }
}
