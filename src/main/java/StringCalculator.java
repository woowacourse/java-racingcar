import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String DELIMITER = ",|:";

    public static boolean isBlank(String s) {
        return s == null || s.isEmpty();
    }

    public static int calculate(String s) {
        if (isBlank(s)) {
            return 0;
        }
        String delimiter = sumOfDelimiter(s);
        String target = extractTarget(s);
        String[] splitStrings = target.split(delimiter);
        int[] splitNumbers = toIntArray(splitStrings);
        return sumOfList(splitNumbers);
    }

    public static String sumOfDelimiter(String s) {
        String delimiter = DELIMITER;
        if (extractCustomDelimiter(s) != "") {
            delimiter = delimiter + "|" + extractCustomDelimiter(s);
        }
        return delimiter;
    }

    public static void validateInteger(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    public static void validatePositiveInteger(String data) {
        int target = Integer.parseInt(data);
        if (target < 0) {
            throw new RuntimeException("[ERROR] 음수가 입력되었습니다.");
        }
    }

    public static int[] toIntArray(String[] testData) {
        int[] result = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            validateInteger(testData[i]);
            validatePositiveInteger(testData[i]);
            result[i] = Integer.parseInt(testData[i]);
        }
        return result;
    }

    public static int sumOfList(int[] numberList) {
        int total = 0;
        for (int number : numberList) {
            total += number;
        }
        return total;
    }

    public static String extractCustomDelimiter(String target) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(target);
        if (m.find()) {
            return m.group(1);
            //String[] tokens = m.group(2).split(customDelimiter);
            // 덧셈 구현
        }
        return "";
    }

    public static String extractTarget(String target) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(target);
        if (m.find()) {
            return m.group(2);
        }
        return target;
    }
}
