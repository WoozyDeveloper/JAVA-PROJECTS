import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final int a = 2;
    private ArrayList<Tile> letters = new ArrayList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            //add a new tile to the collection;
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
//            extracted.add(poll one tile from the collection);
        }
        return extracted;
    }
}