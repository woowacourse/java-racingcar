package calculator;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return sum(toNaturalNumbers(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static List<NaturalNumber> toNaturalNumbers(String[] values) {
        return Arrays.stream(values)
            .map(NaturalNumber::new)
            .collect(toList());
    }

    private static int sum(List<NaturalNumber> numbers) {
        return numbers.stream()
            .mapToInt(NaturalNumber::get)
            .sum();
    }
}
