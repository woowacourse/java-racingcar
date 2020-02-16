package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {
    private static final String OR_OPERATOR = "|";
    
    private static String delimiter = "," + OR_OPERATOR + ":";
    private static final String CUSTOM_DELIMITER_EXPRESSION = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_EXPRESSION);

    public static String[] split(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(delimiter);
    }
}
