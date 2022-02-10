package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String targetString) {
        if (targetString == null || targetString.isBlank()) {
            return 0;
        }

        int sum = 0;
        String separators = ",:";
        String[] splitResult;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(targetString);

        if (m.find()) {
            String customSeparator = m.group(1);
            separators += customSeparator;
            targetString = m.group(2);
        }

        splitResult = targetString.split("[" + separators + "]");

        for (String s : splitResult) {
            sum += toInt(s);
        }

        return sum;
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
