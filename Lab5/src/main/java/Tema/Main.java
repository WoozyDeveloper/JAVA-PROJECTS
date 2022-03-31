package Tema;

import Commands.*;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, TikaException, SAXException {
        AddCommand addCommand = new AddCommand();
        ListCommand listCommand = new ListCommand();
        ReportCommand reportCommand = new ReportCommand();
        ViewCommand viewCommand = new ViewCommand();
        SaveCommand saveCommand = new SaveCommand();
        LoadCommand loadCommand = new LoadCommand();
        InfoCommand infoCommand = new InfoCommand();

        Catalog c = new Catalog();
        Book i1 = new Book("1","ABC","https://","Gigel");
        try {
            addCommand.execute(c, i1);
        }catch(Exception e){
            e.printStackTrace();
        }

        Notebook i2 = new Notebook("2","B","d:/","Altcineva");
        try {
            addCommand.execute(c, i2);
        }catch(Exception e){
            e.printStackTrace();
        }

        Book i3 = new Book("3","CCC","aici","Cineva");
        try {
            addCommand.execute(c, i3);
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            addCommand.execute(c, i3);
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            listCommand.execute(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveCommand.execute(c,"C:\\Users\\adiio\\Desktop");
        reportCommand.execute(c);
        System.out.println("METAAAA");
        infoCommand.execute(i2);
    }
}
