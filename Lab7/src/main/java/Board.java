import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private final int x=2;//a collection for words;
    private String[] words;
    private int index = 0;
    private boolean available = false;
    private String myWord;

    public Board(){
        this.words = new String[100];
        index = 0;
    }

    public boolean isAvailable(){
        return available;
    }

    public synchronized Player setWord(Player player){
        while(available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        if (player.extracted.isEmpty()) {
            return null;
        }
//        while(player.board.isAvailable()) {
//            System.out.println("NUSEPOATE");
//        }
        System.out.println("Extracted tiles:");
        System.out.println(player.extracted);

        System.out.println(player.name + ":");

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        List<Character> letters = new ArrayList<>();
        for (int i=0;i<player.extracted.size();i++)
            letters.add(player.extracted.get(i).getLetter());

        //verific daca am format un cuvant cu literele date
        for (int i=0;i<word.length();i++){
            if (!letters.contains(word.charAt(i))) {
                System.out.println("DADADA");
                return null;
            }
            letters.remove(letters.indexOf(word.charAt(i)));
        }
        System.out.println("E BINE BOSS0");
        letters.clear();

        //scot literele folosite din tile-uri
        for (int i=0;i<player.extracted.size();i++)
            letters.add(player.extracted.get(i).getLetter());
        for (int i=0;i<word.length();i++){
            if (letters.contains(word.charAt(i))) {
                int test = letters.indexOf(word.charAt(i));
                letters.remove(test);
                player.extracted.remove(test);
            }
        }
        System.out.println("E BINE BOSS1");

        //caut cuvantul in dictionar
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
        if(wordFound == false) {
            System.out.println("WORD NOT FOUND");
            //return null;
        }

        System.out.println("E BINE BOSS");

        List<Tile> newExtracted = player.game.getBag().extractTiles(word.length());
        player.extracted.addAll(newExtracted);
        player.board.addWord(player, word);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
        System.out.println("TEST");
        return player;
    }

//    public String setWord(Player player){
//        while(available){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("CITESC");
//        available = true;
//        Scanner scanner = new Scanner(System.in);
//        myWord = scanner.nextLine();
//
//        notifyAll();
//
//        System.out.println("IAU");
//        return myWord;
//    }

    public synchronized String getWord(){
        while(!available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return myWord;
    }

    public void addWord(Player player, String word) {
        //add the word to the collection;
        words[index] = word;
        index++;
    }
    @Override
    public String toString() {
        return words.toString();
    }
}