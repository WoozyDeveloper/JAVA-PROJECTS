package Commands;

import Tema.Catalog;
import Tema.Command;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class SaveCommand implements Command {
    public static void execute(Catalog catalog, String path)
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
