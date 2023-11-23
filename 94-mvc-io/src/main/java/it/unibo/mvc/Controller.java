package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    public String getString();

    public void setString( final String string );

    public List<String> getPrintedStrings();

    public void printString();

    public void printHistory();
}
