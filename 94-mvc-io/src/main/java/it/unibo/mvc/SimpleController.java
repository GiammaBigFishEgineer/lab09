package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

public final class SimpleController implements Controller {

    private List<String> historyPrints = new ArrayList<>();
    private String lastString;

    @Override
    public String getString() {
        return this.lastString;
    }

    @Override
    public void setString( final String string ) {
        this.lastString = string;
    }

    @Override
    public List<String> getPrintedStrings() {
        return this.historyPrints;
    }

    @Override
    public void printString() {
        System.out.println(this.getString());
        this.historyPrints.add(this.getString());
    }

    @Override
    public void printHistory() {
        try{
            this.getPrintedStrings().forEach(System.out::println);
        }catch(IllegalStateException e){
            System.out.println(e);
        }
    }
    
}
