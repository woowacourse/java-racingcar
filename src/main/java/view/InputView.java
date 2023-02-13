package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ENTER_COUNT = "시도할 회수는 몇회인가요?";
    private final static String ERROR_HEADER = "[ERROR] ";
    private final static String EMPTY_INPUT = "입력값이 없습니다.";
    private final static String NOT_PROPER_COUNT = "시도횟수는 양의 정수여야합니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        final String DELIMITER = ",";

        printInputMessage(ENTER_CAR_NAMES);
        String input = readLine();
        validateNotEmpty(input);
        return splitWordsBy(input, DELIMITER);
    }

    public int readCount() throws IllegalArgumentException {
        printInputMessage(ENTER_COUNT);
        String input = readLine();
        validateNotEmpty(input);
        validateCount(input);
        return Integer.parseInt(input);
    }

    private String readLine() {
        return scanner.nextLine().strip();
    }

    private void printInputMessage(String message) {
        System.out.println(message);
    }

    private List<String> splitWordsBy(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1)).map(String::strip)
            .collect(Collectors.toList());
    }

    private void throwError(String errorMessage) {
        throw new IllegalArgumentException(ERROR_HEADER + errorMessage);
    }

    private void validateNotEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throwError(EMPTY_INPUT);
        }
    }

    private void validateCount(final String count) {
        validatePositiveNumber(count);
    }

    private void validatePositiveNumber(final String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException exception) {
            throwError(NOT_PROPER_COUNT);
        }
    }
}
