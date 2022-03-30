import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command{
    public static void execute(Catalog catalog, String path)
            throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        }catch (IOException e)
        {
            System.out.print("Invalid input on save()!!!");
        }
    }
}
