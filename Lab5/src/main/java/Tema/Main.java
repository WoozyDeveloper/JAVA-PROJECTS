package Tema;

import Commands.*;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, TikaException, SAXException {
        Catalog c = new Catalog();
        Book i1 = new Book("1","ABC","https://","Gigel");
        try {
            AddCommand addCommand = new AddCommand(c,i1);
            addCommand.execute();
        }catch(Exception e){
            e.printStackTrace();
        }

        Notebook i2 = new Notebook("2","B","d:/","Altcineva");
        try {
            AddCommand addCommand = new AddCommand(c,i2);
            addCommand.execute();
        }catch(Exception e){
            e.printStackTrace();
        }

        Book i3 = new Book("3","CCC","aici","Cineva");
        try {
            AddCommand addCommand = new AddCommand(c,i3);
            addCommand.execute();
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            AddCommand addCommand = new AddCommand(c,i3);
            addCommand.execute();
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            ListCommand listCommand = new ListCommand(c);
            listCommand.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        SaveCommand saveCommand = new SaveCommand(c,"C:\\Users\\adiio\\Desktop");
        saveCommand.execute();
        ReportCommand reportCommand = new ReportCommand(c);
        reportCommand.execute();
        System.out.println("METAAAA");

        InfoCommand infoCommand = new InfoCommand(i2);
        infoCommand.execute();
    }
}
