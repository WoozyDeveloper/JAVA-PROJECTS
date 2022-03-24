public class Street {
    private String name;
    private int length;
    private Intersection[] intersection = new Intersection[10];

    public Street(String name, int km){
        this.name = name;
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