import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveCommand implements Command{
    public static void execute(Catalog catalog, String path)
            throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        }catch(FileNotFoundException fnfe) {
            System.out.println("No permission");
            fnfe.printStackTrace();
        }
    }
}
