import java.awt.*;
import java.io.File;
import java.util.List;

public class AddCommand implements Command{
    public void execute(Catalog c, Item item) {
        c.getItems().add(item);
    }
}
