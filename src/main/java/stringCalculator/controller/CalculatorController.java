package stringCalculator.controller;

import stringCalculator.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorController {
    private static final String PATTERN = "//(.)\\\\n(.*)";         // 정규표현식 \\ -> \ , 자바 리터럴 \\ -> \

    private final InputView inputView;

    public CalculatorController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String input = inputView.scanInput();
        String delimiters = ",|:";

        if (hasCustomDelimiter(input)) {
            delimiters += ("|" + getCustomDelimiter(input));
        }
        // 커스톰 없는 경우
        System.out.println(getCustomDelimiter(input));
    }

    private boolean hasCustomDelimiter(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);

        return m.find();
    }

    public String getCustomDelimiter(String input) {
        final int delimiterIndex = 1;
        String customDelimiter = "";

        Matcher m = Pattern.compile(PATTERN).matcher(input);

        if (m.find()) {
            customDelimiter = m.group(delimiterIndex);
            isValidDelimiter(customDelimiter);
        }

        return customDelimiter;
    }

    private void isValidDelimiter(String customDelimiter) {
        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw new RuntimeException("커스텀 구분자로 기본 구분자가 지정될 수 없습니다.");
        }
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
            checkNullOrBlank(number);
            checkNumber(number);
        }
    }

    private void checkNullOrBlank(String value) {
        if (value == null || value.equals("")) {
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
