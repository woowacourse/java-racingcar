package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormulaStringSplitter {
    private static final String JOINING_DELIMITER = "|";
    private static final List<String> BASIC_DELIMITERS = Arrays.asList(",", ":");

    public static List<String> split(String customDelimiter, String formula) {
        List<String> delimiters = new ArrayList<>(BASIC_DELIMITERS);
        delimiters.add(customDelimiter);
        String delimiter = String.join(JOINING_DELIMITER, delimiters);
        return Arrays.asList(formula.split(delimiter));
    }

    public static List<String> split(String formula) {
        String delimiter = String.join(JOINING_DELIMITER, BASIC_DELIMITERS);
        return Arrays.asList(formula.split(delimiter));
    }
}
