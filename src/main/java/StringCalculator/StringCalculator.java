package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        String[] tokens = split(text);
        return sum(tokens);
    }

    public static boolean isBlank(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String[] split(String text) {
        Matcher m = Pattern.compile( "//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }

        String[] tokens= text.split(",|:");
        return tokens;
    }

    public static int sum(String[] tokens) {
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            int num = Integer.parseInt(tokens[i]);
            checkNegativeNumber(num);
            result += num;
        }
        return result;
    }

    public static void checkNegativeNumber(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }
}
