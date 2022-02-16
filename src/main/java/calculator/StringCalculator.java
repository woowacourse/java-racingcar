package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;
import static java.util.regex.Pattern.matches;

public class StringCalculator {

    private static final String CUSTOM_DISTRIBUTOR_PATTERN = "//(.)\n(.*)";
    private static final String BASIC_DISTRIBUTOR_PATTERN = ",|:";
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String INVALID_INPUT_ERROR = "정수가 아닌 문자가 포함되어 있습니다.";
    private static final int NUMBER_GROUP = 2;
    private static final int CUSTOM_DISTRIBUTOR = 1;

    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input)) {
            return 0;
        }
        final Matcher matcher = compile(CUSTOM_DISTRIBUTOR_PATTERN).matcher(input);
        if (matcher.find()) {
            checkInvalidInput(matcher.group(NUMBER_GROUP), matcher.group(CUSTOM_DISTRIBUTOR));
            return getSum(matcher.group(NUMBER_GROUP), matcher.group(CUSTOM_DISTRIBUTOR));
        }
        checkInvalidInput(input, BASIC_DISTRIBUTOR_PATTERN);
        return getSum(input, BASIC_DISTRIBUTOR_PATTERN);
    }

    private static boolean checkNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static void checkInvalidInput(String input, String distributor) {
        if (!matches(NUMBER_PATTERN, String.join("", splitNumber(input, distributor)))) {
            throw new RuntimeException(INVALID_INPUT_ERROR);
        }
    }

    private static Integer getSum(String input, String distributor) {
        return Arrays.stream(splitNumber(input, distributor))
                .mapToInt(number -> Integer.parseInt(number))
                .sum();
    }

    private static String[] splitNumber(final String input, final String distributor) {
        return input.split(distributor);
    }
}
