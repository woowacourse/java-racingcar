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

        for(String value : inputs) {
            if (value.contains("-")) {
                throw new RuntimeException("음수는 포함할 수 없습니다.");
            }
        }
        if (inputs.length == 1) {
            return Integer.parseInt(inputs[0]);
        }
        for (String value : inputs) {
            try {
                result += Integer.parseInt(value);
            } catch(IllegalArgumentException e){
                throw new IllegalArgumentException("지정된 구분자가 아닙니다.");
            }
        }
        return result;
    }

    void checkInteger(String a){

    }
}
