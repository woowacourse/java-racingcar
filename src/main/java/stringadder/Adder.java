package stringadder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {
    public static final String MINUS_SIGN = "-";
    public static final char SLASH = '/';
    public static final String EQUATION_PATTERN_WHEN_CUSTOM_MINUS = "(-?\\d)-(-?\\d)-(-?\\d)";
    public static final String NORMAL_SPLIT_DELIMITER = ",|:";
    public static final String INPUT_PATTERN = "//(.)\n(.*)";

    public int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        if (isCustom(inputString)) {
            return sumCustom(inputString);
        }
        return sumNotCustom(inputString);
    }

    public static String[] splitWhenCustom(String number, String customMark) {
        if (customMark.equals(MINUS_SIGN)) {
            return splitWhenCustomMarkIsMinus(number);
        }
        return number.split(customMark);
    }

    public static String[] splitWhenCustomMarkIsMinus(String input) {
        String[] result = new String[3];
        Pattern pattern = Pattern.compile(EQUATION_PATTERN_WHEN_CUSTOM_MINUS);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
            result[2] = matcher.group(3);
        }
        return result;
    }

    public static List<Integer> toIntegerList(String[] input) {
        List<Integer> result = new ArrayList<>();
        for (String str : input) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    private int sumNotCustom(String inputString) {
        NumberValidate.validate(split(inputString));
        return sumWhenList(toIntegerList(split(inputString)));
    }

    private int sumCustom(String inputString) {
        String customMark = customMarkAndNumber(inputString)[0];
        String number = customMarkAndNumber(inputString)[1];
        String[] numbers = splitWhenCustom(number, customMark);
        NumberValidate.validate(numbers);
        return sumWhenList(toIntegerList(numbers));
    }

    private int sumWhenList(List<Integer> finalNumbers) {
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    public String[] split(String inputString) {
        return inputString.split(NORMAL_SPLIT_DELIMITER);
    }

    private boolean isCustom(String inputString) {
        return inputString.charAt(0) == SLASH;
    }

    public String[] customMarkAndNumber(String inputString) {
        Pattern pattern = Pattern.compile(INPUT_PATTERN);
        Matcher matcher = pattern.matcher(inputString);
        String[] result = new String[2];
        while (matcher.find()) {
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
        }
        return result;
    }
}
