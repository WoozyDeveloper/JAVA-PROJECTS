public class Timer implements Runnable{
    boolean done;
    private Game game;
    private int seconds;

    public Timer(int seconds, Game game){
        this.game = game;
        this.seconds = seconds;
        this.done = false;
    }

    public void waitASecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(int i=1;i<=this.seconds;i++)
            waitASecond();
        System.out.println("AM TERMINAT SI AR TREBUI SA SE OPREASCA TOT");
        game.showWinner();
        System.exit(0);
    }
}
