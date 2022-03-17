import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        LinkedList<Street> streetList = new LinkedList<>();
        HashSet<Intersection> intersectionSet = new HashSet<>();

        var streets = IntStream.rangeClosed(0,3)
                .mapToObj(i->new Street("s" + i, 0))
                .toArray(Street[]::new);
        //streets[0].setLength(100);

        var nodes = IntStream.rangeClosed(0,3)
            .mapToObj(i->new Intersection("v" + i) )
            .toArray(Intersection[]::new);
        streetList.addAll(Arrays.asList(streets));

        Collections.sort(streetList,
                Comparator.comparing(u -> String.valueOf(u.getLength())));

//        for(Street s:streetList)
//            System.out.print(s.getName() + " ");

        intersectionSet.addAll(Arrays.asList(nodes));

        intersectionSet.stream()
                .distinct()
                .collect(Collectors.toList());

        for(Intersection i : intersectionSet)
            System.out.print(i.getName() + " ");
    }
}
