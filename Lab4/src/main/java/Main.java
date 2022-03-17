import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        LinkedList<Street> streetList = new LinkedList<Street>();


        var streets = IntStream.rangeClosed(0,3)
                .mapToObj(i->new Street("s" + i, 0))
                .toArray(Street[]::new);
        //streets[0].setLength(100);

        var nodes = IntStream.rangeClosed(0,3)
            .mapToObj(i->new Intersection("v" + i) )
            .toArray(Intersection[]::new);
        streetList.addAll(Arrays.asList(streets));

        Collections.sort(streetList,
                (u,v)->String.valueOf(u.getLength()).compareTo(String.valueOf(v.getLength())));

        for(Street s:streetList)
            System.out.print(s.getName() + " ");
    }
}
