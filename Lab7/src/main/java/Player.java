import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> extracted;
    private boolean done;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        extracted = game.getBag().extractTiles(7);
    }

    public synchronized boolean submitWord() throws InterruptedException {
        done = false;
        if (extracted.isEmpty()) {
            return false;
        }
        System.out.println(extracted);
        String word;
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();

        List <Character> letters = new ArrayList<>();
        for (int i=0;i<extracted.size();i++)
            letters.add(extracted.get(i).getLetter());

        for (int i=0;i<word.length();i++){
            if ( ! letters.contains(word.charAt(i)))
                return false;
            letters.remove(letters.indexOf(word.charAt(i)));
        }

        letters.clear();
        for (int i=0;i<extracted.size();i++)
            letters.add(extracted.get(i).getLetter());
        for (int i=0;i<word.length();i++){
            if (letters.contains(word.charAt(i))) {
                int test = letters.indexOf(word.charAt(i));
                letters.remove(test);
                extracted.remove(test);
            }
        }
        boolean wordFound = false;
        File file = new File("src/main/resources/dictionar.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                if(word == line){
                    wordFound = true;
                    break;
                }
            }
            // line is not visible here.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(wordFound == false)
            return false;

        List<Tile> newExtracted = game.getBag().extractTiles(word.length());
        extracted.addAll(newExtracted);
        game.getBoard().addWord(this, word);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        done = true;
        return true;

    }


    public String getName(){
        return this.name;
    }

    public void setGame(Game g){
        this.game = g;
    }

    @Override
    public void run(){
        while(true) {
            try {
                synchronized (this) {
                        System.out.println(submitWord());
                        wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
