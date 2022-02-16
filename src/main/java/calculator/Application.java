package calculator;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Application {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String BASE_DELIMITER_PATTERN = ",|:";

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(runCalculator(askInput()));
    }

    public static int runCalculator(String input) {
        if (isNotValidateInput(input)) {
            return 0;
        }

        return sumAndDivideInput(input);
    }

    private static boolean isNotValidateInput(String input) {
        return isNullInput(input) || isEmptyInput(input) || isBlankInput(input);
    }

    private static boolean isBlankInput(String input) {
        return input.isBlank();
    }

    private static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private static boolean isNullInput(String input) {
        return input == null;
    }

    private static String askInput() throws IOException {
        return bufferedReader.readLine();
    }

    private static int sumAndDivideInput(String input) {
        if (hasCustomDelimiterInInput(input)) {
            List<String> numbersDividedByCustomDelimiter = divideNumbersByCustomDelimiter(input);
            checkValidateNumbers(numbersDividedByCustomDelimiter);
            return makeSumOfNumbers(numbersDividedByCustomDelimiter);
        }

        checkValidateNumbers(input);
        return makeSumOfNumbers(divideInput(input));
    }

    private static void checkValidateNumbers(List<String> numbers) {
        numbers.forEach(Application::checkValidateNumber);
    }

    private static void checkValidateNumbers(String numbers) {
        Stream.of(numbers).forEach(Application::checkValidateNumber);
    }

    private static void checkValidateNumber(String number) {
        if (isRightNumber(number)) {
            return;
        }
        throw new RuntimeException();
    }

    private static boolean isRightNumber(String number) {
        if (number.equals(",") || number.equals(":")) {
            return true;
        }
        return Character.isDigit((number.charAt(0)));
    }

    private static boolean hasCustomDelimiterInInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private static List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1) + "|" + BASE_DELIMITER_PATTERN;
            return Arrays.asList(matcher.group(2).split(delimiter));
        }
        throw new RuntimeException();
    }

    private static int makeSumOfNumbers(List<String> numbers) {
        int sumOfNumbers = 0;
        for (String number : numbers) {
            sumOfNumbers += Integer.parseInt(number);
        }
        return sumOfNumbers;
    }

    private static List<String> divideInput(String input) {
        return Arrays.asList(input.split(BASE_DELIMITER_PATTERN));
=======
public class Application {

    public static void main(String[] args) {

>>>>>>> 3454ff5 (test: 사용자 입력 공백 예외 테스트함수 작성)
    }
}
