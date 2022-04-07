import java.util.List;

public class Player implements Runnable{
    private String word;
    private Game game;
    private String name;

    public Player(String name) { this.name = name; }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        //create a word with all the extracted tiles;
        game.getBoard().addWord(this, word);
        //make the player sleep 50ms;
        return true;
    }


    public String getName(){
        return this.name;
    }

    public void setGame(Game g){
        this.game = g;
    }

    @Override
    public void run() {

    }
}
