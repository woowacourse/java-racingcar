package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] texts = parseText(text);
        int[] numbers = Arrays.stream(texts).mapToInt(Integer::parseInt).toArray();
        hasNegative(numbers);
        return Arrays.stream(numbers).reduce(0, (total, x) -> total + x);
    }

    private static String[] parseText(String text) {
        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return text.split(delimiter);
    }

    private static void hasNegative(int[] numbers) {
        if (Arrays.stream(numbers).anyMatch(number -> number < 0)) {
            throw new RuntimeException();
        }
    }
}
