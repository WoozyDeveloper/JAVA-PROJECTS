import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        LinkedList<Street> streetList = new LinkedList<Street>();


        var nodes = IntStream.rangeClosed(0,3)
            .mapToObj(i->new Intersection("v" + i) )
            .toArray(Intersection[]::new);

        final int dim = 3;
        Street[] street = new Street[dim];
        street[0] = new Street(nodes[0],nodes[1],10);
        street[1] = new Street(nodes[1],nodes[2],20);
        street[2] = new Street(nodes[2],nodes[0],30);

        streetList.addAll(Arrays.asList())
    }
}
