package racingcar.view;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String READ_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INVALID_COUNT_MESSAGE = "시도할 회수는 정수만 입력할 수 있습니다. 입력한 값 : ";

    private final InputValidator inputValidator;
    private final Scanner scanner;

    public InputView(final InputValidator inputValidator, final Scanner scanner) {
        this.inputValidator = inputValidator;
        this.scanner = scanner;
    }

    public List<String> readCarNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String input = scanner.nextLine();

        final List<String> names = splitAndParseNames(input);
        inputValidator.validateNames(names);

        return names;
    }

    private List<String> splitAndParseNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(toUnmodifiableList());
    }

    public int readCount() {
        System.out.println(READ_COUNT_MESSAGE);
        String input = scanner.nextLine();

        final int count = parseNumber(input);
        inputValidator.validateCount(count);

        return count;
    }

    private int parseNumber(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE + input);
        }
    }
}
