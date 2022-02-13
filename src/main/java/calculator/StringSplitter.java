package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.CalculatorValidation.isValidMatcher;

public class StringSplitter {

    private static final StringSplitter stringSplitter = new StringSplitter();
    private static final String CUSTOM_PREFIX = "//";

    private StringSplitter() {
    }

    public static StringSplitter getInstance() {
        return stringSplitter;
    }

    public String[] splitString(String str) {
        if (str.startsWith(CUSTOM_PREFIX)) {
           return customSplit(str);
        }

        return defaultSplit(str);
    }

    private String[] defaultSplit(String str) {
        return str.split(",|:");
    }

    private String[] customSplit(String str) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        isValidMatcher(matcher);

        String customDelimiter = matcher.group(1);

        return matcher.group(2).split(customDelimiter);
    }
}
