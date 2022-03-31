package Commands;

import Tema.Catalog;
import Tema.Command;
import Tema.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog c,String path){
        this.catalog=c;
        this.path=path;
    }
    public void execute()
            throws IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(Paths.get("catalog.json").toFile(), catalog);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Eroare la salvare. . .");
        }
    }
}
