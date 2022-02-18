package calculator;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int DEFAULT_RETURN_NUMBER = 0;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 불가합니다!";

    public int splitAndSum(String text) {
        if (!validateEmptyNum(text)) {
            return DEFAULT_RETURN_NUMBER;
        }

        Matcher compiledMatcher = Pattern.compile(CUSTOM_REGEX).matcher(text);

        if (compiledMatcher.find()) {
            String customDelimiter = compiledMatcher.group(1);
            return sum(compiledMatcher.group(2).split(customDelimiter));
        }

        return sum(text.split(DEFAULT_DELIMITER));
    }

    private boolean validateEmptyNum(String text) {
        return text != null && !"".equals(text);
    }

    private int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .filter(this::filterNegativeNum)
                .reduce(0, Integer::sum);
    }

    private boolean filterNegativeNum(Integer num) {
        if (isNegative(num)) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private boolean isNegative(Integer num) {
        return num < 0;
    }
}
