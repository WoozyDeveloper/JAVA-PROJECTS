public class Street {
    private String name;
    private int km;
    private int length;
    private Intersection intersection1, intersection2;

    public Street(Intersection i1, Intersection i2, int km){
        this.intersection1 = i1;
        this.intersection2 = i2;
        this.km = km;
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
