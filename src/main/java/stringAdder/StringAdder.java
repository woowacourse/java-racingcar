package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static int add(String value) throws RuntimeException {
        int result = 0;

        if (value == null || value.isEmpty()) {
            return 0;
        }
        String[] values = value.split(",|:");

        for (String number : values) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
            result += Integer.parseInt(number);
        }
        return result;
    }
}