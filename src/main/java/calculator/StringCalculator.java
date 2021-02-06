package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int ZERO_VALUE = 0;
    private static final int SEPARATOR_LOCATION = 1;
    private static final int NUMBER_LOCATION = 2;
    private static final String NULL_VALUE = null;
    private static final String SEPARATOR = ",|:";
    private static final String OR = "|";

    static int splitAndSum(String text) {
        if (checkNullValue(text)) {
            return ZERO_VALUE;
        }
        return calculateNumbers(text);
    }

    private static boolean checkNullValue(String text) {
        if (text == NULL_VALUE) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }

        return false;
    }

    private static int calculateNumbers(String text) {
        List<String> parsedNumbers = parsingNumbers(text);
        List<Integer> integerNumbers = parsedNumbers.stream()
                .map(stringNumber -> Integer.parseInt(stringNumber))
                .collect(Collectors.toList());
        checkNegative(integerNumbers);
        return integerNumbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static List<String> parsingNumbers(String text) {
        String[] numbers;
        numbers = separateNumbers(text);
        List<String> list = Arrays.asList(numbers);
        return list;
    }

    private static String[] separateNumbers(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String separator = customizeSeparator(matcher);
            return matcher.group(NUMBER_LOCATION).split(separator);
        }
        return text.split(SEPARATOR);
    }

    private static String customizeSeparator(Matcher matcher) {
        return SEPARATOR + OR + matcher.group(SEPARATOR_LOCATION);
    }

    private static void checkNegative(List<Integer> numbers){
        long count = numbers.stream()
            .filter(element -> element < ZERO_VALUE)
            .count();

        if (count != ZERO_VALUE) {
            throw new RuntimeException();
        }
    }
}