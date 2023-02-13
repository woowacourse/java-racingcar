package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ENTER_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        final String DELIMITER = ",";

        printInputMessage(ENTER_CAR_NAMES);
        String input = readLine();
        validateNotEmpty(input);
        List<String> carNames = splitWordsBy(input, DELIMITER);
        validateCarNames(carNames);
        return carNames;
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
        final String ERROR_HEADER = "[ERROR] ";

        throw new IllegalArgumentException(ERROR_HEADER + errorMessage);
    }

    private void validateNotEmpty(final String input) {
        final String EMPTY_INPUT = "입력값이 없습니다.";

        if (input == null || input.isBlank()) {
            throwError(EMPTY_INPUT);
        }
    }

    private void validateCarNames(final List<String> carNames) {
        carNames.forEach(this::validateCarNameLength);
        validateDuplication(carNames);
    }

    private void validateCarNameLength(final String carName) {
        final String NOT_PROPER_CAR_NAME_LENGTH = "자동차 이름 길이는 %d자 이상, %d자 이하여야합니다.";
        final int MIN_CAR_NAME_LENGTH = 1;
        final int MAX_CAR_NAME_LENGTH = 5;

        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throwError(String.format(NOT_PROPER_CAR_NAME_LENGTH, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH));
        }
    }

    private void validateDuplication(final List<String> carNames) {
        final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다.";

        if (carNames.stream().distinct().count() != carNames.size()) {
            throwError(DUPLICATE_CAR_NAME);
        }
    }

    private void validateCount(final String count) {
        validatePositiveNumber(count);
        validateRange(Integer.parseInt(count));
    }

    private void validatePositiveNumber(final String count) {
        final String NOT_PROPER_COUNT = "시도횟수는 양의 정수여야합니다.";

        try {
            Integer.parseInt(count);
        } catch (NumberFormatException exception) {
            throwError(NOT_PROPER_COUNT);
        }
    }

    private void validateRange(final int count) {
        final String NOT_PROPER_COUNT = "올바르지 않은 시도횟수입니다.(1 ~ 999,999,999)";

        final int MIN_COUNT = 1;
        final int MAX_COUNT = 999_999_999;

        if (count < MIN_COUNT || count > MAX_COUNT) {
            throwError(NOT_PROPER_COUNT);
        }
    }
}
