package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public List<String> split(String input) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if (m.find()) {
            return Arrays.asList(m.group(2).split(m.group(1)));
        }
        return Arrays.asList(input.split(DEFAULT_SEPARATOR));
    }
}
