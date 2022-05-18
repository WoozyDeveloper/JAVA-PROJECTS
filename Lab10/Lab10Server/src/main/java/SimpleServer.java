import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer extends Thread{
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public static boolean accept = true;
    public static int dim = 0;
    public void run(){
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(50000);
                // Execute the client's request in a new thread
                if(accept) {
                    new ClientThread(socket).start();
                }
                else if(dim == 0)
                    break;
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}