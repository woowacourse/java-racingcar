package calculator;

import calculator.resource.Constants;
import calculator.util.InputStrValidator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String FIRST_TARGET_STRING = "//";
    private static final String LAST_TARGET_STRING = "\n";

    public static int splitAndSum(final String inputString) {
        if (InputStrValidator.isEmptyOrNull(inputString)) {
            return 0;
        }
        if (InputStrValidator.isHasOnlyOneNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        return sumNumbers(splitInputStr(inputString));
    }

    private static int sumNumbers(final List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> splitInputStr(final String inputString) {
        List<String> splitStrings = Arrays.asList(removeCustomDelimiterDefiner(inputString)
                .split(getDelimiter(inputString)));

        splitStrings = getOnlyNumbers(splitStrings);
        InputStrValidator.checkValidNumbers(splitStrings);
        return parseNumbers(splitStrings);
    }

    private static String removeCustomDelimiterDefiner(final String inputString) {
        return inputString.replace(FIRST_TARGET_STRING, "")
                .replace(LAST_TARGET_STRING, "");
    }

    private static List<String> getOnlyNumbers(final List<String> splitStrings) {
        return splitStrings.stream()
                .filter(s -> !"".equals(s))
                .collect(Collectors.toList());
    }

    private static String getDelimiter(final String inputString) {
        String delimiter = Constants.BASIC_DELIMITER;
        String customDelimiter = findCustomDelimiter(inputString);
        if (isNoCustomDelimiter(customDelimiter)) {
            return delimiter;
        }
        delimiter = delimiter + (Constants.DELIMITER_DIVIDER + customDelimiter);
        return delimiter;
    }

    private static boolean isNoCustomDelimiter(final String customDelimiter) {
        return "".equals(customDelimiter);
    }

    private static String findCustomDelimiter(final String inputString) {
        Matcher m = PATTERN.matcher(inputString);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
        }
        return customDelimiter;
    }

    private static List<Integer> parseNumbers(final List<String> splitStrings) {
        return splitStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
