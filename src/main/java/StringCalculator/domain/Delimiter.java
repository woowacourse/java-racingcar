package stringcalculator.domain;

import stringcalculator.exception.IllegalCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterPositionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static stringcalculator.Utils.isNumeric;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_FORMAT = "//(.)\n(.*)";

    private String delimiter;
    private boolean isCustom;

    private Delimiter(String input) {
        if (!isUsingCustomDelimiter(input)) {
            setDefaultDelimiter();
            return;
        }

        setCustomDelimiter(input);
    }

    private void setDefaultDelimiter() {
        delimiter = DEFAULT_DELIMITER;
        isCustom = false;
    }

    private void setCustomDelimiter(String input) {
        validatePrefixedCustomDelimiterFormat(input);
        String customDelimiter = extractCustomDelimiter(input);
        checkNumericDelimiter(customDelimiter);

        isCustom = true;
        delimiter = Pattern.quote(customDelimiter);
    }

    public static Delimiter from(String input) {
        return new Delimiter(input);
    }

    public static Delimiter DEFAULT() {
        return new Delimiter("");
    }

    public boolean isCustom() {
        return isCustom;
    }

    public String getDelimiter() {
        return delimiter;
    }

    private Matcher createCustomDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_FORMAT).matcher(input);
    }

    private boolean isUsingCustomDelimiter(String input) {
        Matcher matcher = createCustomDelimiterMatcher(input);

        return matcher.find();
    }

    private void validatePrefixedCustomDelimiterFormat(String input) {
        int index = -1;
        Matcher matcher = createCustomDelimiterMatcher(input);

        if (matcher.find()) {
            index = matcher.start();
        }

        if (index != 0) {
            throw new IllegalCustomDelimiterPositionException();
        }
    }

    private String extractCustomDelimiter(String input) {
        Matcher m = createCustomDelimiterMatcher(input);

        if (m.find()) {
            return m.group(1);
        }

        return DEFAULT_DELIMITER;
    }

    private void checkNumericDelimiter(String delimiter) {
        if (isNumeric(delimiter)) {
            throw new IllegalCustomDelimiterException();
        }
    }
}
