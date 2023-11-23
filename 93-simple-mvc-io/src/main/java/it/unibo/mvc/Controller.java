package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file;
    private static final String PATH = System.getProperty("user.home") + File.separator;

    public Controller(){
        this.file = new File( PATH + "output.txt" );
    }

    public void setFile(final String file){
        this.file = new File( PATH + file );
    }

    public File getFile(){
        return this.file;
    }

    public String getPath(){
        return this.file.getAbsolutePath();
    }

    public void saveStream(final String input){
        try (PrintStream ps = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            ps.print(input);
        } catch (IOException e1) {
            System.out.println(e1);
        }
    }
}
