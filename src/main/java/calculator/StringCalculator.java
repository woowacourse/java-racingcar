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

            char splitDelimiter = customDelimiter.charAt(2);
            if (Character.isDigit(splitDelimiter)) {
                throw new RuntimeException("구분자로 숫자를 사용할 수 없습니다.");
            }

            String splitText = text.substring(4);

            String regex = getDelimiter(text);
            String[] values = splitText.split(regex);
            return getTotal(values);
        }
        // todo split
        // todo sum
        String[] values = text.split(",|:");
        return getTotal(values);
    }

    private static int getTotal(String[] values) {
        int total = 0;
        for (String value : values) {
            total += getPositiverNumber(value);;
        }
        return total;
    }

    private static int getPositiverNumber(String value) {
        int toInt = Integer.parseInt(value);
        validatePositiveNumber(toInt);
        return toInt;
    }

    private static void validatePositiveNumber(int toInt) {
        if(toInt < 0) {
            throw new RuntimeException("입력값은 0 이상이어야 합니다.");
        }
    }

    private static String getDelimiter(String text) {
        String delimiter = text.substring(2, 3);
        return Pattern.matches("[*+^]", delimiter) ? "\\" + delimiter : delimiter;
    }
}
