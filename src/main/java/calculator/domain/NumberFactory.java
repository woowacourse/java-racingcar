package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberFactory {
    public static Numbers makeNumbers(String expression) {
        List<Number> numbers = Arrays.stream(splitExpression(expression))
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    private static String[] splitExpression(String expression) {
        String delimeter = ",|:";
        expression = expression.replace("\\n", "\n");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            delimeter = m.group(1);
            expression = m.group(2);
            System.out.println(expression);
        }
        return expression.split(delimeter);
    }
}
