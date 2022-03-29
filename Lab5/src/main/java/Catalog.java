
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{

    private String name;
    private List<Item> items = new ArrayList<>();

    //…
    public void add(Item item) {
        items.add(item);
    }

    public void save(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(Paths.get("catalog.json").toFile(),this);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Eroare la salvare. . .");
        }
    }

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
