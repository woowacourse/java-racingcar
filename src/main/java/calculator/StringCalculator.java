package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static String[] splitString(String s) {
        String regExp = ",|:";
        if (isCustom(s)) {
            int idx = s.indexOf("\n");
            regExp = s.substring(2, idx);
            s = s.substring(idx + 1);
        }

        return s.split(regExp);
    }

    private static boolean isCustom(String s) {
        return s.startsWith("//") && s.contains("\n");
    }

    public static List<Integer> convertToIntegerArray(String[] arr) {
        List<Integer> numList = new ArrayList<>();
        for (String num : arr) {
            numList.add(convertToInt(num));
        }

        return numList;
    }

    private static Integer convertToInt(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("입력 값은 숫자여야 합니다.");
        }

        if (value < 0) {
            throw new RuntimeException("입력 값은 0 이상의 정수여야 합니다.");
        }

        return value;
    }
}
