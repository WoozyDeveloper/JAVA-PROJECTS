package Commands;

import Tema.Catalog;
import Tema.Command;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
        public static void execute(Catalog catalog, String path)
            throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        }catch (IOException e)
        {
            System.out.print("Unavailable input when loading!!!");
        }
    }
}