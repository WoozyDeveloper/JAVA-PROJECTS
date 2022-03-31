package Commands;

import Exceptions.InvalidItemException;
import Tema.Catalog;
import Tema.Command;
import Tema.Item;

import java.awt.*;
import java.io.File;
import java.util.List;

public class AddCommand implements Command {
    public void execute(Catalog c, Item item) throws InvalidItemException {
        if(c.findById(item.getId()) != null){
            System.out.println("ID for " + item.getTitle() + " already exists!!!");
        }
        else
            c.getItems().add(item);
    }
}
