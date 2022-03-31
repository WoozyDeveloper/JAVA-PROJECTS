package Commands;

import Exceptions.InvalidItemException;
import Tema.Catalog;
import Tema.Command;
import Tema.Item;

import java.util.List;

public class ListCommand implements Command {
    private Catalog c;

    public ListCommand(Catalog c){
        this.c=c;
    }
    //print the list of items on the screen
    public void execute(/*Catalog c*/) throws InvalidItemException {
        for(Item item : c.getItems())
            System.out.println(item);
    }
}
