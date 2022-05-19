import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            while(true) {
                Scanner scanner = new Scanner(System.in);
                // Send a request to the server
                String request = scanner.nextLine();
                if(request.equals("exit")) {
                    System.out.println("Goodbye!");
                    System.exit(1);
                }
                out.println(request);
                String response = in.readLine();
                if(response.equals("enterPassword")) {
                    System.out.println("Parola. . .");
                    String password = scanner.nextLine();
                    out.println(password);
                    response=in.readLine();
                    System.out.println(response);
                }
                if(response.equals("read")){
                    System.out.println(in.readLine());
                    System.out.println("am primit semnal de la read");
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
