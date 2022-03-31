package Commands;

import Tema.Catalog;
import Tema.Command;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {

    //creates and opens an HTML report representing the content of the catalog
    public void execute(Catalog c) throws IOException, TemplateException {
        String catalogInfo = c.toString();
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(Catalog.class,"/");

        Template infoTemplate = config.getTemplate("html.html");
        StringWriter writer = new StringWriter();
        Map<String,Object> infoMap = new HashMap<>();
        infoMap.put("info",catalogInfo);

        infoTemplate.process(infoMap,writer);
        System.out.println(writer);

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("html.html", false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.print(writer);
            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {}
        }
        try {
            Desktop d = Desktop.getDesktop();
            File file = new File("html.html");
            d.open(file);
        }
        catch (Exception evt) {
            System.out.println("Error at Desktop()");
        }
    }
}
