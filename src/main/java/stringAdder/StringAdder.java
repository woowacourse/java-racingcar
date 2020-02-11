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
            try {
                int operand = Integer.parseInt(s);
                if (operand < 0) {
                    throw new RuntimeException("음수는 입력하실 수 없습니다.");
                }
                result += operand;
            }catch(NumberFormatException e){
                throw new RuntimeException("숫자 이외의 값은 입력하실 수 없습니다.");
            }
        }
        return result;
    }
}