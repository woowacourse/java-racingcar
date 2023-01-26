package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (matcher.find()) {
            String numberString = matcher.group(2);
            String customDelimiter = matcher.group(1);
            return splitByDelimiterAndSum(numberString, customDelimiter);
        }

        return splitByDelimiterAndSum(inputString, "[,:]");
    }

    public static int splitByDelimiterAndSum(String numberString, String delimiter) {
        return Arrays.stream(numberString.split(delimiter))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}