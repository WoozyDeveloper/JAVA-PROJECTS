import com.github.javafaker.Faker;

import java.util.ArrayList;

public class Street {
    private String name;
    private int index;
    private int length;
    private ArrayList<Intersection> intersection = new ArrayList<>();
    private ArrayList<Street> neighbourStreet = new ArrayList<>();

    public int getIndex(){
        return this.index;
    }

    public ArrayList<Street> getNeighbours(){
        return neighbourStreet;
    }

    public int getNumberOfNeighbourStreets(){
        return neighbourStreet.size();
    }

    public void addNeighbourStreet(Street s){
        neighbourStreet.add(s);
    }

    public Street(int index, int km){
        Faker faker =  new Faker();
        this.index = index;
        this.name = faker.address().streetName();
        this.length = km;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
