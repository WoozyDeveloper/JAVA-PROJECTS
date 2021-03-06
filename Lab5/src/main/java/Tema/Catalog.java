package Tema;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{

    private String name;
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems(){return this.items;}

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=\n" + items +
                '}';
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
