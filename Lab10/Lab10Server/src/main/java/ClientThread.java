import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ClientThread extends Thread implements Commands{
    private String name = null;
    private Socket socket = null ;
    private PrintWriter out;
    private static final String registerCommand = "register";
    private static final String loginCommand = "login";
    private static final String friendCommand = "friend";
    private static final String sendCommand = "send";
    private static final String readCommand = "read";
    private static final String stopCommand = "stop";

    public String processCommand(String command) throws IOException {
        String arr[] = command.split(" ", 2);
        if(arr[0].equals(registerCommand)){
            return register(arr[1]);
        }
        else if(arr[0].equals(loginCommand)){
            String res = login(arr[1]);
            if(res.equals("logged"))
                name = arr[1];
        }
        else if(arr[0].equals(friendCommand)){
            friend(arr[1]);
        }
        else if(arr[0].equals(sendCommand)){
            send(arr[1]);
        }
        else if(arr[0].equals(readCommand)){
            read();
        }
        else if(arr[0].equals(stopCommand)){
            stopServer();
        }
        return "DA";
    }

    public ClientThread (Socket socket) { this.socket = socket ; }

    public void run () {
        try {
            while(true) {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                //read what the client sent
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                out = new PrintWriter(socket.getOutputStream());
                String raspuns = processCommand(request);
                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                SimpleServer.dim--;
                SimpleServer.accept = false;
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

    @Override
    public String register(String name) throws IOException {
        File myUsers = null;
        myUsers = new File("src/main/resources/users.txt");

        File newFile = null;

        try (BufferedReader br = new BufferedReader(new FileReader(myUsers))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                if(name.equals(line)){
                    return "User already exists";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("src/main/resources/users.txt",true);
             BufferedWriter bw = new BufferedWriter(fw)){
            bw.append(name+'\n');
            newFile = new File("src/main/resources/" + name + ".txt");
            newFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("New user " + name);
        out = new PrintWriter(socket.getOutputStream());

        //send a signal to let the user write his password
        String raspuns = "enterPassword";
        out.println(raspuns);
        out.flush();

        //receive the password and put it in the passwords.txt file
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String password = in.readLine();
        System.out.println("password="+password);
        try (FileWriter fw = new FileWriter("src/main/resources/passwords.txt",true);
             BufferedWriter bw = new BufferedWriter(fw)){
            bw.append(password+'\n');
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public String login(String name) {
        int lineIndex = 0;
        File myUsers = null;
        myUsers = new File("src/main/resources/users.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(myUsers))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                if(name.equals(line)){
                    //send a signal to let the user write his password
                    String raspuns = "enterPassword";
                    out.println(raspuns);
                    out.flush();

                    //receive the password and put it in the passwords.txt file
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    String password = in.readLine();
                    System.out.println("password="+password);


                    File myPasswords = null;
                    myUsers = new File("src/main/resources/passwords.txt");
                    int lineIndex2 = 0;
                    try (BufferedReader br2 = new BufferedReader(new FileReader(myUsers))) {
                        String line2;
                        while ((line2 = br2.readLine()) != null) {
                            // process the line.
                            if(lineIndex == lineIndex2 && password.equals(line2)){
                                //user logged in
                                //send a signal to login the user
                                String res = "loggedIn";
                                out.println(res);
                                out.flush();
                                System.out.println("LOGGED IN");
                                SimpleServer.dim++;
                                break;
                            }
                            lineIndex2++;
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                lineIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "logged";
    }

    @Override
    public void friend(String names) {
        String[] arr = names.split(" ",0);
        System.out.println("FRIENDs");
        String fileName = "src/main/resources/" + this.name + ".txt";
        try (FileWriter fw = new FileWriter(fileName,true);
             BufferedWriter bw = new BufferedWriter(fw)){
                bw.append(names + "\n");
                for(String currentFileName : arr) {
                    if(!currentFileName.equals(this.name)) {
                        System.out.println("ADAUGAT");
                        String fileName2 = "src/main/resources/" + currentFileName + ".txt";
                        System.out.println("FILE = " + fileName2);
                        try (FileWriter fw2 = new FileWriter(fileName2, true);
                             BufferedWriter bw2 = new BufferedWriter(fw2)) {
                            bw2.append(this.name + "\n");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String message) {
        String filePath = "src/main/resources/" + this.name + ".txt";
        File myFriends = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(myFriends))) {
            String line;
            line = br.readLine();
            System.out.println("Line = " + line);



            String[] arr = line.split(" ", 0);
            for(String friend : arr) {
                System.out.println("FRIENDs");
                String fileName = "src/main/resources/" + friend + ".txt";
                try (FileWriter fw = new FileWriter(fileName, true);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.append(message + "\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer(){
        SimpleServer.accept = false;
        out.println("Server off . . .");
    }

        @Override
    public void read() {
        String messages = "";
        out.println("read");
        out.flush();
        System.out.println("reading>>");

        String filePath = "src/main/resources/" + this.name + ".txt";
        File myFriends = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(myFriends))) {
            String line;
            line = br.readLine();
            line = br.readLine();
            while(line != null){
                messages += line;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("M:" + messages);
        out.println(messages);
        out.flush();
    }
}