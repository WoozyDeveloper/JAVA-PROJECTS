import java.awt.*;
import java.io.File;
import java.util.List;

public class AddCommand implements Command{
    public void execute(Catalog c, Item item) {
        boolean found = false;
        for(Item i : c.getItems())
            if(i.getId() == item.getId()){
                System.out.println("ID for " + item.getTitle() + " already exists!!!");
                found = true;
                break;
            }
        if(found == false)
            c.getItems().add(item);
    }
}
