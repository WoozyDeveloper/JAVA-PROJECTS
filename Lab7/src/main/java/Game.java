import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Thread {
    Timer timer;
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    public Player winner = null;
    private int maxPlayers = 3;
    private int currentPlayer = 0;
    private Player bestPlayer = new Player("null",this,-1);
    private List<Thread> threads = new ArrayList<>();


    public Game() {
        timer = new Timer(5, this);
    }

    public void start() {
        Thread thread1 = new Thread(new Player("P1", this, 0));
        Thread thread2 = new Thread(new Player("P2", this, 1));
        Thread thread3 = new Thread(new Player("P3", this, 2));
        Thread timerThread = new Thread(timer);

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);

        thread1.start();
        thread2.start();
        thread3.start();
        timerThread.start();
    }

    public Bag getBag(){
        return this.bag;
    }

    public Board getBoard(){
        return this.board;
    }

    public synchronized void performRound(Player player) throws InterruptedException {
        if(!isPlayersTurn(player.playerNumber)) {
            wait();
        }
        while(!player.performRound())
            continue;

        if(bestPlayer.getTotalScore() < player.getTotalScore())
            bestPlayer = player;
        nextPlayer();
    }

    public void showWinner(){
        System.out.println("Castigatorul este: " + bestPlayer.name);
    }

    public synchronized void nextPlayer() {
        //System.out.print("Moving counter from player " + currentPlayer);
        currentPlayer = ++currentPlayer % maxPlayers;
        //System.out.println(" to player " + currentPlayer);
    }

    public synchronized boolean isPlayersTurn(int playerNumber) {
        notify();
        return currentPlayer == playerNumber;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}