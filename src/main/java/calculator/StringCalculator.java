package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final StringBuilder SB = new StringBuilder();
    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\\n(.*)";
    private static final String MULTIPLE_SEPARATOR = "|";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return ZERO;
        }
        String[] numbers = init(text);
        int sum = ZERO;
        for (String number: numbers) {
            sum += parseIntegerNumber(number);
        }
        return sum;
    }

    private static String[] init(String text) {
        SB.append(DEFAULT_DELIMITER);
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(text);
        if (m.find()) {
            SB.append(MULTIPLE_SEPARATOR);
            SB.append(m.group(FIRST));
            text = m.group(SECOND);
        }
        String[] numbers = text.split(SB.toString());
        SB.setLength(ZERO);
        return numbers;
    }

    private static int parseIntegerNumber(String number) {
        int intNumber = Integer.parseInt(number);
        positiveNumberCheck(intNumber);
        return intNumber;
    }

    private static void positiveNumberCheck(int intNumber) {
        if (intNumber < ZERO) {
            throw new RuntimeException();
        }
    }
}
