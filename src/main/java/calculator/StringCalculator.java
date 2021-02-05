package calculator;

import calculator.resource.Constants;
import calculator.util.InputStrValidator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int splitAndSum(String inputStr) {
        if (InputStrValidator.isEmptyOrNull(inputStr)) {
            return 0;
        }
        if (InputStrValidator.isHasOnlyOneNumber(inputStr)) {
            return Integer.parseInt(inputStr);
        }
        return sumNumbers(splitInputStr(inputStr));
    }

    private static int sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> splitInputStr(String inputStr) {
        List<String> splitStrings = Arrays.asList(removeCustomDelimiterDefiner(inputStr)
                .split(getDelimiter(inputStr)));

        splitStrings = getOnlyNumbers(splitStrings);
        InputStrValidator.checkValidNumbers(splitStrings);
        return parseNumbers(splitStrings);
    }

    private static String removeCustomDelimiterDefiner(String inputStr) {
        return inputStr.replace("//", "")
                .replace("\n", "");
    }

    private static List<String> getOnlyNumbers(List<String> splitStrings) {
        return splitStrings.stream()
                .filter(s -> !"".equals(s))
                .collect(Collectors.toList());
    }

    private static String getDelimiter(String inputStr) {
        String delimiter = Constants.BASIC_DELIMITER;
        String customDelimiter = findCustomDelimiter(inputStr);
        if (isNoCustomDelimiter(customDelimiter)) {
            return delimiter;
        }
        delimiter = delimiter + (Constants.DELIMITER_DIVIDER + customDelimiter);
        return delimiter;
    }

    private static boolean isNoCustomDelimiter(String customDelimiter) {
        return "".equals(customDelimiter);
    }

    private static String findCustomDelimiter(String inputStr) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputStr);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
        }
        return customDelimiter;
    }

    private static List<Integer> parseNumbers(List<String> splitStrings) {
        return splitStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
