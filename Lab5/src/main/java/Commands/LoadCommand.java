package Commands;

import Tema.Catalog;
import Tema.Command;
import Tema.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    private Catalog c;
    private String path;

    public LoadCommand(Catalog c,String p){
        this.c=c;
        this.path=p;
    }
        public void execute(/*Catalog catalog, String path*/)
            throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    c);
        }catch (IOException e)
        {
            System.out.print("Unavailable input when loading!!!");
        }
    }
}