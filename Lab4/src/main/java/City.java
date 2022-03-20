import java.util.*;

public class City {
    Map<Intersection,List<Street>> cityMap = new HashMap<>();
    List<Street> street;
    List<Intersection> intersection;
    int[][] matrix;

    public City(List<Street> str, List<Intersection> inter){
        this.street = str;
        this.intersection = inter;

        matrix = new int[inter.size()][inter.size()];
    }

    public void displayLongerStreets(int value){
        street.stream()
                .filter(str -> str.getLength() > value)
                .filter(str -> str.getNumberOfNeighbourStreets() >= 3+1)// +1 pt ca se afla si ea insasi
                .forEach(str -> System.out.print("str. " + str.getName() + ", "));
        System.out.println();
    }
}
