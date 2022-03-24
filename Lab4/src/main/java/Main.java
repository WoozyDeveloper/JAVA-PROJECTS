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
        var street = IntStream.rangeClosed(0,15)
                .mapToObj(i->new Street(0))
                .toArray(Street[]::new);


        for(int i=0;i<street.length;i++)
            street[i].setIndex(i);

        int index = 0;
        /**
         * Generate intersections
         */
        var intersection = IntStream.rangeClosed(0,8)
            .mapToObj(i->new Intersection() )
            .toArray(Intersection[]::new);

        for(Intersection i : intersection)
            i.setIndex(index++);

        for(Intersection i : intersection)
            System.out.print("Index " + i.getIndex());

        //region length of streets
        street[0].setLength(2,intersection[0],intersection[1]);
        street[1].setLength(2,intersection[0],intersection[2]);
        street[2].setLength(2,intersection[0],intersection[3]);
        street[3].setLength(2,intersection[1],intersection[2]);
        street[4].setLength(1,intersection[2],intersection[3]);
        street[5].setLength(3,intersection[1],intersection[4]);
        street[6].setLength(2,intersection[2],intersection[6]);
        street[7].setLength(2,intersection[2],intersection[5]);
        street[8].setLength(3,intersection[3],intersection[5]);
        street[9].setLength(1,intersection[4],intersection[5]);
        street[10].setLength(1,intersection[4],intersection[7]);
        street[11].setLength(2,intersection[4],intersection[8]);
        street[12].setLength(1,intersection[6],intersection[7]);
        street[13].setLength(1,intersection[6],intersection[8]);
        street[14].setLength(3,intersection[5],intersection[8]);
        street[15].setLength(1,intersection[7],intersection[8]);
        //endregion

        streetList.addAll(Arrays.asList(street));

        //region intersections setup
        intersection[0].AddStreet(street[0],intersection[1]);
        intersection[0].AddStreet(street[1],intersection[2]);
        intersection[0].AddStreet(street[2],intersection[3]);

        intersection[1].AddStreet(street[0],intersection[0]);
        intersection[1].AddStreet(street[3],intersection[2]);
        intersection[1].AddStreet(street[5],intersection[4]);

        intersection[2].AddStreet(street[1],intersection[0]);
        intersection[2].AddStreet(street[3],intersection[1]);
        intersection[2].AddStreet(street[4],intersection[3]);
        intersection[2].AddStreet(street[7],intersection[5]);
        intersection[2].AddStreet(street[6],intersection[6]);

        intersection[3].AddStreet(street[2],intersection[0]);
        intersection[3].AddStreet(street[4],intersection[2]);
        intersection[3].AddStreet(street[8],intersection[5]);

        intersection[4].AddStreet(street[5],intersection[1]);
        intersection[4].AddStreet(street[9],intersection[5]);
        intersection[4].AddStreet(street[10],intersection[7]);
        intersection[4].AddStreet(street[11],intersection[8]);

        intersection[5].AddStreet(street[7],intersection[2]);
        intersection[5].AddStreet(street[8],intersection[3]);
        intersection[5].AddStreet(street[9],intersection[4]);
        intersection[5].AddStreet(street[14],intersection[8]);

        intersection[6].AddStreet(street[6],intersection[2]);
        intersection[6].AddStreet(street[12],intersection[7]);
        intersection[6].AddStreet(street[13],intersection[8]);

        intersection[7].AddStreet(street[10],intersection[4]);
        intersection[7].AddStreet(street[12],intersection[6]);
        intersection[7].AddStreet(street[15],intersection[8]);

        intersection[8].AddStreet(street[11],intersection[4]);
        intersection[8].AddStreet(street[14],intersection[5]);
        intersection[8].AddStreet(street[13],intersection[6]);
        intersection[8].AddStreet(street[15],intersection[7]);

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
         * check for duplicates(even if it's not possible)
         */
        intersectionSet.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.print("Intersections: ");
        for(Intersection i : intersectionSet)
            System.out.print(i.getName() + ", ");
        System.out.println();

        //streets[1].setLength(1);

        /**
         * create a city with streets and intersections
         */
        City city = new City(streetList, List.of(intersection));

        /**
         * display the streets longer than the value and with at least 3 other neighbour streets
         */
        city.displayLongerStreets(2);
        System.out.println();
//        for(Street s : street)
//            System.out.print("dim= " + s.getLength() + ", ");


    }
}
