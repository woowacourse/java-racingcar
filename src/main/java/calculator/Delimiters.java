package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String OR = "|";

    private static List<String> delimiters = new ArrayList<String>();

    public Delimiters() {
        delimiters.add(COMMA);
        delimiters.add(COLON);
    }

    public void addCustomDelimiters(String customDelimiter){
        delimiters.add(customDelimiter);
    }

    public String getDelimiters(){
        return String.join(OR, delimiters);
    }
}
