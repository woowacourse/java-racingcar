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
        System.out.println(sb.toString());
        String[] numbers = text.split(sb.toString());
        int sum = 0;
        for (String number: numbers) {
            sum += Integer.parseInt(number);
        }
        sb.setLength(0);
        return sum;
    }
}
