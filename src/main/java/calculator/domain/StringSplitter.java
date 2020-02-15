package calculator.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSplitter {

    private static final Pattern PATTERN = null;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    public static List<Integer> splitString(String expression) {
        Matcher matcher = PATTERN.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);

        String delimiter = DEFAULT_DELIMITER;
        if (matcher.find()) {
            delimiter = matcher.group(DELIMITER_GROUP);
            expression = matcher.group(EXPRESSION_GROUP);
        }

        return Stream.of(expression.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
