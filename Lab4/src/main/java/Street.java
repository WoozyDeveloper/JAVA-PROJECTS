import com.github.javafaker.Faker;

import java.util.ArrayList;

public class Street {
    private int index;
    private String name;
    private int length;
    private ArrayList<Street> neighbourStreet = new ArrayList<>();

    public void setIndex(int index){
        this.index = index;
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

    public Street(int km){
        Faker faker =  new Faker();
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
