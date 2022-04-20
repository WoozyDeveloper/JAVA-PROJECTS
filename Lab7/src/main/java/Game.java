import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Thread {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    private boolean winner = false;
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public Game(){

    }

    public void play() throws InterruptedException {
        System.out.println(players.size());
        ArrayList<Thread> myThreads = new ArrayList<>();
        for (int i=0;i<players.size();i++) {
            Runnable myRunnable = players.get(i);
            Thread thread = new Thread(myRunnable);
            myThreads.add(thread);
            thread.start();
        }
    }

    public Bag getBag(){
        return this.bag;
    }

    public Board getBoard(){
        return this.board;
    }

    public static void main(String args[]) {
        Game game = new Game();
        Player p1 = new Player("Adi",game);
        Player p2 = new Player("Rares", game);
        game.addPlayer(p1);
        game.addPlayer(p2);
        try {
            game.play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}