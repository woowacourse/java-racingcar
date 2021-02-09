package stringcalculator.controller;

import stringcalculator.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorController {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
    private static final int ZERO = 0;
    private static final String DELIMITER_SEPARATOR = "|";
    private static final int DELIMITER_INDEX = 1;
    private static final int NUMBERS_INDEX = 2;
    private static final String COMMA = ",";
    private static final String COLON = ":";

    private final InputView inputView;

    public CalculatorController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String input = inputView.scanInput();

        System.out.println(parseAndSum(input));
    }

    public int parseAndSum(String input) {
        if (checkNullOrEmpty(input)) {
            return ZERO;
        }
        return splitAndSum(extractNumbers(input), extractDelimiters(input));
    }

    private boolean checkNullOrEmpty(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    public String extractNumbers(String input) {
        Matcher m = PATTERN.matcher(input);

        if (m.find()) {
            return m.group(NUMBERS_INDEX);
        }
        return input;
    }

    private String extractDelimiters(String input) {
        String delimiters = COMMA + DELIMITER_SEPARATOR + COLON;

        if (hasCustomDelimiter(input)) {
            return delimiters + (DELIMITER_SEPARATOR + extractCustomDelimiter(input));
        }
        return delimiters;
    }

    private boolean hasCustomDelimiter(String input) {
        Matcher m = PATTERN.matcher(input);
        return m.find();
    }

    public String extractCustomDelimiter(String input) {
        String customDelimiter = "";

        Matcher m = PATTERN.matcher(input);

        if (m.find()) {
            customDelimiter = m.group(DELIMITER_INDEX);
            isValidDelimiter(customDelimiter);
        }
        return customDelimiter;
    }

    private void isValidDelimiter(String customDelimiter) {
        if (COMMA.equals(customDelimiter) || COLON.equals(customDelimiter)) {
            throw new RuntimeException("커스텀 구분자로 기본 구분자가 지정될 수 없습니다.");
        }
    }

    public int splitAndSum(String value, String delimiters) {
        List<Integer> numbers = splitNumbers(value, delimiters);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> splitNumbers(String value, String delimiters) {
        String[] numbers = value.split(delimiters);

        isValidNumbers(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void isValidNumbers(String[] numbers) {
        for (String number : numbers) {
            checkCharacterNullOrEmpty(number);
            checkNumber(number);
        }
    }

    private void checkCharacterNullOrEmpty(String value) {
        if (checkNullOrEmpty(value)) {
            throw new RuntimeException("숫자 문자열만 입력해 주세요");
        }
    }

    private void checkNumber(String value) {
        int number = 0;

        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 문자열만 입력해 주세요");
        }

        if (number < 0) {
            throw new RuntimeException("양수 문자열만 입력해 주세요");
        }
    }
}
