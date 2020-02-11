package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static int add(String value) throws RuntimeException {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        int result = 0;
        String customDelimiter = (",|:");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            customDelimiter = m.group(1);
            if (m.group(2) == null || m.group(2).isEmpty()) {
                return 0;
            }
            String[] tokens = m.group(2).split(customDelimiter);
            for (String token : tokens) {
                result += Integer.parseInt(token);
            }
            return result;
        }
        String[] values = value.split(customDelimiter);
        for (String s : values) {
            if (Integer.parseInt(s) < 0) {
                throw new RuntimeException();
            }
            result += Integer.parseInt(s);
        }
        return result;
    }
}