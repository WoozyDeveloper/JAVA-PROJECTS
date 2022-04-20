import java.util.*;

public class Bag {
    private Map<Character,Integer> letterMap = new HashMap<>();
    private final int maxPoints = 10;
    private final int minPoints = 1;
    private final int a = 2;
    private ArrayList<Tile> letters = new ArrayList<>();
    private Random random;
    public Bag() {
        random = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            Tile myTile = new Tile(c,random.nextInt(maxPoints - minPoints) + minPoints);
            for(int i = 1; i <= 10; i++)
                this.letters.add(myTile);
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            int index = random.nextInt(letters.size());
            extracted.add(letters.get(index));
            letters.remove(index);
        }
        return extracted;
    }

    public void printTiles(){
        System.out.println();
    }
}