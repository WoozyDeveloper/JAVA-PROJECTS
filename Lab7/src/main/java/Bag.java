import java.util.*;

public class Bag {
    private Map<Character,Integer> letterMap = new HashMap<>();
    private final int maxPoints = 10;
    private final int minPoints = 1;
    private final int a = 2;
    public ArrayList<Tile> letters = new ArrayList<>();
    private Random random;
    public Bag() {
        random = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            int dim = 0,points=0;
            switch(c){
                case 'a':
                    points=1;
                    dim = 9;
                    break;
                case 'b':
                    points=3;
                    dim = 2;
                    break;
                case 'c':
                    points=3;
                    dim = 2;
                    break;
                case 'd':
                    points=2;
                    dim = 4;
                    break;
                case 'e':
                    points=1;
                    dim = 12;
                    break;
                case 'f':
                    points=4;
                    dim = 2;
                    break;
                case 'g':
                    points=2;
                    dim = 3;
                    break;
                case 'h':
                    points=4;
                    dim = 2;
                    break;
                case 'i':
                    points=1;
                    dim = 9;
                    break;
                case 'j':
                    points=8;
                    dim = 1;
                    break;
                case 'k':
                    points=5;
                    dim = 1;
                    break;
                case 'l':
                    points=1;
                    dim = 4;
                    break;
                case 'm':
                    points=3;
                    dim = 2;
                    break;
                case 'n':
                    points=1;
                    dim = 6;
                    break;
                case 'o':
                    points=1;
                    dim = 8;
                    break;
                case 'p':
                    points=3;
                    dim = 2;
                    break;
                case 'q':
                    points=10;
                    dim = 1;
                    break;
                case 'r':
                    points=1;
                    dim = 6;
                    break;
                case 's':
                    points=1;
                    dim = 4;
                    break;
                case 't':
                    points=1;
                    dim = 6;
                    break;
                case 'u':
                    points=1;
                    dim = 4;
                    break;
                case 'v':
                    points=4;
                    dim = 2;
                    break;
                case 'w':
                    points=4;
                    dim = 2;
                    break;
                case 'x':
                    points=8;
                    dim = 1;
                    break;
                case 'y':
                    points=4;
                    dim = 2;
                    break;
                case 'z':
                    points=10;
                    dim = 1;
                    break;
            }

            Tile myTile = new Tile(c,points);
            for(int i = 1; i <= dim; i++)
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