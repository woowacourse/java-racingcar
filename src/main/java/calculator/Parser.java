package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    String regex = ",|:";

    public String[] splitter(String input) {
        if (input == null || input.isEmpty()) {
            input = "0";
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            regex = m.group(1);
            input = m.group(2);
        }
        return input.split(regex);
    }

    public void checkNumber(String[] values) {
        for(String value:values) {
            if(!Character.isDigit(value.charAt(0))) {
                throw new RuntimeException("숫자만 가능");
            }
        }
    }
}
