package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int result = 0;
        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter += "|" + customDelimiter;
            input = m.group(2);
        }
        String[] inputs = input.split(delimiter);

        if (inputs.length == 1) {
            return Integer.parseInt(inputs[0]);
        }
        for (String val : inputs) {
            result += Integer.parseInt(val);
        }
        return result;
    }
}
