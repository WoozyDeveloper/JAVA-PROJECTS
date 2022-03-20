import java.util.ArrayList;
import java.util.List;

public class City {
    List<Street> street;
    List<Intersection> intersection;
    int[][] matrix;

    public City(List<Street> str, List<Intersection> inter){
        this.street = str;
        this.intersection = inter;

        matrix = new int[inter.size()][inter.size()];
        this.buildMatrix();
    }

    public void buildMatrix(){
        ArrayList<Street> ngh = new ArrayList<>();
        int index = 0;
        for(Street s : street){
            ngh = new ArrayList<>();
            ngh = s.getNeighbours();
            for(int i=0;i<ngh.size();i++)
                matrix[index][ngh.get(i).getIndex()] = ngh.get(i).getLength();
            index++;
        }
    }

    public void printMatrix(){
        for(int i=0;i<intersection.size();i++){
            for(int j=0;j<intersection.size();j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void displayLongerStreets(int value){
        street.stream()
                .filter(str -> str.getLength() > value)
                .filter(str -> str.getNumberOfNeighbourStreets() >= 2)
                .forEach(str -> System.out.print("str. " + str.getName() + " " + str.getIndex() + ", "));
        System.out.println();
    }
}
