import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {

    private int totalScore;
    public String name;
    public int playerNumber;
    public Game game;
    public Board board;
    public List<Tile> extracted;


    public int getTotalScore(){
        return this.totalScore;
    }

    public int calculateScore(String word){
        int score = 0;
//        List <Character> letters = new ArrayList<>();
//        for (int i = 0; i < extracted.size(); i++)
//            letters.add(extracted.get(i).getLetter());
        for(int i=0;i<word.length();i++){
            for(Tile tile : game.getBag().letters){
                //System.out.println(tile.getLetter() + " ===> " + tile.getPoints());
                if(word.charAt(i) == tile.getLetter()) {
                    score += tile.getPoints();
                    break;
                    //System.out.println(word.charAt(i) + " -> " + tile.getPoints());
                }
            }
        }
        System.out.println("Points for the word: " + score + " for: " + word);
        totalScore += score;
        System.out.println("Total points: " + totalScore);
        return score;
    }

    public Player(String name, Game game, int playerNumber) {
        this.totalScore = 0;
        this.name = name;
        this.game = game;
        this.playerNumber = playerNumber;
        this.board = game.getBoard();
        extracted = game.getBag().extractTiles(7);
    }

    @Override
    public void run() {
        try {
            while(game.timer.done == false) {
                game.performRound(this);
                System.out.println("VALOARE => " + game.timer.done);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NU MERGE");
        System.out.println(this.name + ", points = " + this.totalScore);
    }

    public synchronized boolean performRound() throws InterruptedException {
        System.out.println("Player " + name + " picks tiles, submit words....");
        if (extracted.isEmpty()) {
            System.out.println("0 tile-uri");
            return false;
        }
        System.out.println(extracted);
        String word;
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();
        List <Character> letters = new ArrayList<>();
        List <Character> backupLetters = new ArrayList<>();

        if(!extracted.isEmpty()) {
            for (int i = 0; i < extracted.size(); i++)
                letters.add(extracted.get(i).getLetter());
        }
//        System.out.println(letters.size());
//        for(int i=0;i<letters.size();i++)
//            System.out.print(letters.get(i));
        for (int i=0;i<word.length();i++){
            if (!letters.contains(word.charAt(i))) {
                System.out.println("Nu ai aceasta litera");
                return false;
            }
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
        System.out.println("WORD E: " + word);
        File file = new File("src/main/resources/dictionar.txt");
        List<String> dictionaryWords = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                dictionaryWords.add(line);
            }
            // line is not visible here.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String currentWord : dictionaryWords){
            if(currentWord.equals(word))
            {
                System.out.println("AM GASIT");
                wordFound = true;
            }
        }

        if(wordFound == false) {
            for(int i=0;i<letters.size();i++)
                System.out.print(letters.get(i));
            System.out.println("\nCuvantul nu exista in dictionar + " + word);
            return false;
        }


        List<Tile> newExtracted = game.getBag().extractTiles(word.length());
        extracted.addAll(newExtracted);
        game.getBoard().addWord(this, word);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculateScore(word);
        System.out.println("toate bune");
        return true;
    }

}
