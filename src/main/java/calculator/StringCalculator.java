package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final StringBuilder sb = new StringBuilder();

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        sb.append(",|:");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            sb.append('|');
            sb.append(m.group(1));
            text = m.group(2);
        }
        String[] numbers = text.split(sb.toString());
        int sum = 0;
        for (String number: numbers) {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new RuntimeException();
            }
            sum += intNumber;
        }
        sb.setLength(0);
        return sum;
    }
}
