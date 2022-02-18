package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASE_DELIMITER_PATTERN = ",|:";
    private static final String OR = "|";
    private static final int DELIMITER = 1;
    private static final int NUMBERS = 2;

    private InputView() {
    }

    public static String askInput() throws IOException {
        return bufferedReader.readLine().replace("\\n", "\n");
    }

    public static boolean hasCustomDelimiterInInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.find();
    }

    public static List<String> dividesByCustomAndCheckValidate(String input) {
        List<String> numbers = divideNumbersByCustomDelimiter(input);
        InputValidator.checkValidateNumbers(numbers);
        return numbers;
    }

    public static List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER) + OR + BASE_DELIMITER_PATTERN;
            return List.of(matcher.group(NUMBERS).split(delimiter));
        }
        throw new RuntimeException();
    }

    public static List<String> divideNumbersByDelimiterAndCheckValidate(String input) {
        InputValidator.checkValidateNumbers(List.of(input.split("")));
        return List.of(input.split(BASE_DELIMITER_PATTERN));
    }
}
