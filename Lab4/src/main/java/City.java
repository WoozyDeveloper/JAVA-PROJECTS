import java.util.*;

public class City {
    private Map<Intersection,List<Street>> cityMap = new HashMap<>();
    private List<Street> street;
    private static List<Intersection> intersection;
    int[][] matrix;

    public static int getNumberOfIntersections(){
        return intersection.size();
    }

    public City(List<Street> str, List<Intersection> inter){
        this.street = str;
        this.intersection = inter;

        matrix = new int[inter.size()][inter.size()];
        buildMatrix();
        printMatrix();
        MST t = new MST();
        t.primMST(matrix);
    }

    public Street findStreet(Intersection from, Intersection to){
        for(Street s : street){
            if((s.getFrom() == from && s.getTo() == to)
                || (s.getFrom() == to && s.getTo() == from)) {
                //System.out.println("Am returnat " + s.getLength());
                return s;
            }
        }
        System.out.println("Not found :((");
        return null;
    }

    public void buildMatrix(){
        for(Intersection i1 : intersection){
            for(Intersection i2 : i1.getOtherIntersections()){
                matrix[i1.getIndex()][i2.getIndex()] = findStreet(i1,i2).getLength();
            }
        }
    }

    public void printMatrix(){
        for(int i=0;i<intersection.size();i++){
            for(int j=0;j<intersection.size();j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void displayLongerStreets(int value){
        street.stream()
                .filter(str -> str.getLength() > value)
                .filter(str -> str.getNumberOfNeighbourStreets() >= 4)
                .forEach(str -> System.out.print("str. " + str.getName() + ", "));
        System.out.println();
    }
}
