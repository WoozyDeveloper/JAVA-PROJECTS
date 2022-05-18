import java.io.IOException;

public interface Commands {
    String register(String name) throws IOException;
    String login(String name);
    void friend(String names);
    void send(String message);
    void read();
    void stopServer();
}
