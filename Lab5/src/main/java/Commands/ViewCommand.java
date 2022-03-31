package Commands;

import Tema.Catalog;
import Tema.Command;
import Tema.Item;

import java.awt.*;
import java.io.File;

public class ViewCommand implements Command {
    private Catalog c;
    private Item item;
    //open an item using native OS application
    public void execute(/*Item item*/){
        try {
            Desktop d = Desktop.getDesktop();
            File file = new File(item.getLocation());
            d.open(file);
        }
        catch (Exception evt) {
            System.out.println("Error at Desktop()");
        }
    }
}
