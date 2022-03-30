import java.util.List;

public class ListCommand implements Command{
    //print the list of items on the screen
    public void execute(List<Item> items){
        for(Item item : items)
            System.out.println(item);
    }
}
