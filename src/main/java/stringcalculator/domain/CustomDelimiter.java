package stringcalculator.domain;

import stringcalculator.exception.ExtractCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterPositionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static stringcalculator.Utils.isNumeric;

public class CustomDelimiter implements Delimiter {
    private final String delimiter;

    private CustomDelimiter(String input) {
        validateCustomDelimiterPosition(input);

        String delimiter = extractCustomDelimiter(input);

        validateNumericDelimiter(delimiter);

        this.delimiter = Pattern.quote(delimiter);
    }

    public static CustomDelimiter valueOf(String input) {
        return new CustomDelimiter(input);
    }

    private void validateCustomDelimiterPosition(String input) {
        int index = -1;
        Matcher matcher = DelimiterFactory.CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            index = matcher.start();
        }

        if (index != 0) {
            throw new IllegalCustomDelimiterPositionException();
        }
    }

    private String extractCustomDelimiter(String input) {
        Matcher matcher = DelimiterFactory.CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new ExtractCustomDelimiterException();
    }

    private void validateNumericDelimiter(String delimiter) {
        if (isNumeric(delimiter)) {
            throw new IllegalCustomDelimiterException();
        }
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }
}
