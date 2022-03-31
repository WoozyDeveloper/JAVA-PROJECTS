package Commands;

import Tema.Item;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.nio.charset.StandardCharsets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class InfoCommand {
    public static String extractContentUsingFacade(InputStream stream)
            throws IOException, TikaException {

        Tika tika = new Tika();
        String content = tika.parseToString(stream);
        return content;
    }
    public static Metadata extractMetadatatUsingFacade(InputStream stream)
            throws IOException, TikaException {
        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        tika.parse(stream, metadata);
        return metadata;
    }

    public void execute(Item c) throws TikaException, IOException, SAXException {
        //detecting the file type
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File("html.html"));
        ParseContext pcontext=new ParseContext();

        //Text document parser
        TXTParser TexTParser = new TXTParser();
        TexTParser.parse(inputstream, handler, metadata,pcontext);
        System.out.println("Contents of the document:" + handler.toString());
        System.out.println("Metadata of the document:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name + " : " + metadata.get(name));
        }
    }
}
