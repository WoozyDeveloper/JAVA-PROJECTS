import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException {
        AddCommand addCommand = new AddCommand();
        ListCommand listCommand = new ListCommand();
        ReportCommand reportCommand = new ReportCommand();
        ViewCommand viewCommand = new ViewCommand();
        SaveCommand saveCommand = new SaveCommand();
        LoadCommand loadCommand = new LoadCommand();

        Catalog c = new Catalog();
        Book i1 = new Book("1","ABC","https://","Gigel");
        addCommand.execute(c,i1);

        Notebook i2 = new Notebook("2","B","d:/","Altcineva");
        addCommand.execute(c,i2);

        Book i3 = new Book("3","CCC","aici","Cineva");
        addCommand.execute(c,i3);
        c.save();
        reportCommand.execute(c);
    }
}
