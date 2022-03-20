import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        LinkedList<Street> streetList = new LinkedList<>();
        HashSet<Intersection> intersectionSet = new HashSet<>();


        /**
         * Generate streets
         */
        var street = IntStream.rangeClosed(0,3)
                .mapToObj(i->new Street(i,4))
                .toArray(Street[]::new);

        /**
         * Generate intersections
         */
        var intersection = IntStream.rangeClosed(0,3)
            .mapToObj(i->new Intersection() )
            .toArray(Intersection[]::new);

        streetList.addAll(Arrays.asList(street));

        //region
        intersection[0].AddStreet(street[1]);
        intersection[0].AddStreet(street[2]);
        intersection[0].AddStreet(street[3]);
        intersection[0].AddStreet(street[0]);

        intersection[1].AddStreet(street[0]);
        intersection[1].AddStreet(street[2]);

        intersection[2].AddStreet(street[0]);
        intersection[2].AddStreet(street[1]);

        intersection[3].AddStreet(street[0]);
        //endregion

        /**
         * Sort streets by their length
         */
        Collections.sort(streetList,
                Comparator.comparing(u -> String.valueOf(u.getLength())));

        /**
         * add the streets in a set
         */
        intersectionSet.addAll(Arrays.asList(intersection));

        /**
         * check for duplicates(even if it's not posible)
         */
        intersectionSet.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.print("Intersections: ");
        for(Intersection i : intersectionSet)
            System.out.print(i.getName() + ", ");

        //streets[1].setLength(1);
        System.out.println();

        /**
         * create a city with streets and intersections
         */
        City city = new City(List.of(street), List.of(intersection));

        /**
         * display the streets longer than the value and with at least 3 other neighbour streets
         */
        city.displayLongerStreets(3);
        city.printMatrix();
    }
}
