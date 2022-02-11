package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String givenString) {
        if (checkNull(givenString)) {
            return 0;
        }
        String[] splitString = split(givenString);
        return sumStringArray(splitString);
    }


    private boolean checkNull(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return true;
        }
        return false;
    }

    private String[] split(String givenString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return givenString.split("[,:]");
    }

    private int sumStringArray(String[] splitString) {
        int result = 0;
        for (int i = 0; i < splitString.length; i++) {
            int value = intValueOf(splitString[i]);
            checkNegativeInteger(value);
            result += value;
        }
        return result;
    }

    private int intValueOf(String givenString) {
        try {
            int result = Integer.parseInt(givenString);
            return result;
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
