package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String text) {
        if (checkNullOrEmpty(text)) {
            return 0;
        }
        String[] splitString = split(text);
        int[] intValues = stringToIntArray(splitString);
        for (int intValue : intValues) {
            checkNegativeInteger(intValue);
        }
        return Arrays.stream(intValues).sum();
    }

    private boolean checkNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private int[] stringToIntArray(String[] splitString) {
        int[] intArray = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            intArray[i] = intValueOf(splitString[i]);
        }
        return intArray;
    }

    private int intValueOf(String givenString) {
        try {
            return Integer.parseInt(givenString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자값을 입력해주세요");
        }
    }

    private void checkNegativeInteger(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
