package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String targetString) {
        if (targetString == null || targetString.isEmpty()) {
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
            int integer = toInt(s);
            if (integer < 0) {
                throw new RuntimeException("음수를 입력하면 안 됩니다.");
            }
            sum += integer;
        }

        return sum;
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
