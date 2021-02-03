package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String defaultSeparator = ",|:";
    private static final String delimiterSeparator = "|";

    public static int splitAndSum(String input) {
        if(checkIsNull(input)){
            return 0;
        }

        if (checkIsEmpty(input)) {
            return 0;
        }

        if(isOnlyNumber(input)) {
            return Integer.parseInt(input);
        }

        // custom 구분자가 있는 경우
        StringBuilder customSeparator = new StringBuilder();
        Matcher matcher = Pattern.compile("//(.+)\n(.*)").matcher(input);
        if (matcher.find()) {
            customSeparator.append(delimiterSeparator);
            customSeparator.append(matcher.group(1));
            input = matcher.group(2);
        }

        // split by delimiter
        String[] strings = splitBySeparator(input, defaultSeparator + customSeparator.toString());

        // check each string is numeric

        // check each string is zero or positive number
        int[] nums = parseToIntegerArray(strings);
        return addNums(nums);
    }

    private static boolean checkIsNull(String input) {
        return input == null;
    }

    private static boolean checkIsEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isOnlyNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNegativeNumber(int num) {
        return num < 0;
    }

    private static String[] splitBySeparator(String input, String separator){
        return input.split(separator);
    }

    private static int[] parseToIntegerArray(String[] strings){
        return Arrays.stream(strings)
                .peek(s -> {
                    if(!isOnlyNumber(s)) {
                        throw new RuntimeException();
                    }
                })
                .mapToInt(Integer::parseInt)
                .peek(s -> {
                    if(isNegativeNumber(s)) {
                        throw new RuntimeException();
                    }
                })
                .toArray();
    }

    private static int addNums(int[] nums){
        int sum =0;

        for(int num : nums){
            sum += num;
        }

        return sum;
    }
}
