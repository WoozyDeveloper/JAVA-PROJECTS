import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Intersection {
    private String name;
    private ArrayList<Street> street = new ArrayList<>();
    private ArrayList<Intersection> to = new ArrayList<>();

    public ArrayList<Street> getStreets() {
        return street;
    }

    public ArrayList<Street> GetStreets(){
        return street;
    }

    public Intersection(String name, ArrayList<Street> street) {
        this.name = name;
        this.street = street;
    }

    public Intersection() {
        Faker faker = new Faker();

        this.name = faker.animal().name();
    }

    public void AddStreet(Street s, Intersection to){
        street.add(s);
        this.to.add(to);
        s.addNeighbourStreet(s);
        s.addNeighbourStreet(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
