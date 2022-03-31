package Tema;

import Exceptions.InvalidCatalogException;
import Exceptions.InvalidItemException;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface Command {
    public void execute() throws InvalidItemException, InvalidCatalogException, IOException, TemplateException;
}
