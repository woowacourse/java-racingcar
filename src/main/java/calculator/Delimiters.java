package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String JOIN_WITH_OR = "|";

    private static List<String> delimiters;

    public Delimiters() {
        delimiters = new ArrayList<String>();
        delimiters.add(DELIMITER_COMMA);
        delimiters.add(DELIMITER_COLON);
    }

    public void addCustomDelimiters(final String customDelimiter) {
        delimiters.add(customDelimiter);
    }

    public String toString() {
        return String.join(JOIN_WITH_OR, delimiters);
    }
}
