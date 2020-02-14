package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String NEGATIVE_VALUE_INCLUDED = "음수가 포함되어 있습니다.";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        List<String> numbers = splitNumbers(expression);
        if (numbers.stream().anyMatch(x -> Integer.parseInt(x) < 0)) {
            throw new RuntimeException(NEGATIVE_VALUE_INCLUDED);
        }
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static List<String> splitNumbers(String expression) {
        String delimeter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            delimeter = m.group(1);
            expression = m.group(2);
        }
        return Arrays.asList(expression.split(delimeter));
    }
}