import java.util.Arrays;

public class Tile {
    private char letter;
    private int points;

//    public Tile(char letter) {
//        this.letter = letter;
//
//        // Points are predefined
//        if(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R').contains(letter)) {
//            points = 1;
//        } else if(Arrays.asList('D', 'G').contains(letter)) {
//            points = 2;
//        } else if(Arrays.asList('B', 'C', 'M', 'P').contains(letter)) {
//            points = 3;
//        } else if(Arrays.asList('F', 'H', 'V', 'W', 'Y').contains(letter)) {
//            points = 4;
//        } else if(Arrays.asList('k').contains(letter)) {
//            points = 5;
//        } else if(Arrays.asList('J', 'X').contains(letter)) {
//            points = 8;
//        } else if(Arrays.asList('Q', 'Z').contains(letter)) {
//            points = 10;
//        }
//    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }


    public Tile(char letter, int points) {
        this.letter=letter;
        this.points=points;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "letter=" + letter +
                ", points=" + points +
                '}';
    }
}
