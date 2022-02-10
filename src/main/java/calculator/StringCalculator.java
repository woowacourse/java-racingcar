package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static String CUSTOM_START = "//";
    private static String REGEX_CUSTOM = "[/]{2}.\\s";

    public static int splitAndSum(String text) {
        if (text.substring(0, 2).equals(CUSTOM_START)) {
            String customDelimiter = text.substring(0, 4);
            if(!Pattern.matches(REGEX_CUSTOM, customDelimiter)) {
                throw new RuntimeException("올바르지 않은 구분자 입력입니다.");
            }

            if (Character.isDigit(customDelimiter.charAt(2))) {
                throw new RuntimeException("구분자로 숫자를 사용할 수 없습니다.");
            }

            // todo split and sum
            return -1;
        }
        // todo split
        // todo sum
        return 3;
    }
}
