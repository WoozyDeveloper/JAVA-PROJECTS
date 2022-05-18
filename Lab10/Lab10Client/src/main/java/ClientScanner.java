import java.util.Scanner;

public class ClientScanner extends Thread{

    Scanner scanner = new Scanner(System.in);
    String command="";
    @Override
    public void run() {
        while(true)
            command = scanner.nextLine();
    }

    public void resetCommand(){
        this.command="";
    }

    public String getCommand(){
        return this.command;
    }
}
