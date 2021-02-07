package stringcalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterFactory {
    private static final String CUSTOM_DELIMITER_FORMAT = "//(.)\r\n(.*)";
    static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_FORMAT);

    private DelimiterFactory() {
    }

    public static Delimiter valueOf(String input) {
        if (!isUsingCustomDelimiter(input)) {
            return new DefaultDelimiter();
        }

        return CustomDelimiter.valueOf(input);
    }

    private static boolean isUsingCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        return matcher.find();
    }

    public static Delimiter DEFAULT() {
        return valueOf("");
    }
}