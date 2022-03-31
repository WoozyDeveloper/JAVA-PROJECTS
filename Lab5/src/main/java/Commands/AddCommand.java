package Commands;

import Exceptions.InvalidItemException;
import Tema.Catalog;
import Tema.Command;
import Tema.Item;

import java.awt.*;
import java.io.File;
import java.util.List;

public class AddCommand implements Command {
    private Catalog c;
    private Item item;
    public AddCommand(Catalog c, Item i){
        this.c=c;
        this.item=i;
    }
    public void execute() throws InvalidItemException {
        if(c.findById(item.getId()) != null){
            System.out.println("ID for " + item.getTitle() + " already exists!!!");
        }
        else
            c.getItems().add(item);
    }
}
