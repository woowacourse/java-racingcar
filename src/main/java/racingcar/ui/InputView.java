package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.util.TextSplit;

public class InputView implements TextSplit {

    private static final int MINIMUM_TRY_COUNT = 1;
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> carNames() {
        try {
            String input = input();

            if (!input.contains(DELIMITER)) {
                throw new IllegalArgumentException("[ERROR] 구분자(" + DELIMITER + ")가 필요해요.");
            }

            return split(input, DELIMITER);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return carNames();
        }
    }

    public int tryCount() {
        try {
            return inputTryCount();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return tryCount();
        }
    }

    private int inputTryCount() throws IllegalArgumentException {
        int tryCount;

        try {
            tryCount = Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능해요");
        }
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MINIMUM_TRY_COUNT + "미만일 수 없어요.");
        }

        return tryCount;
    }

    private String input() {
        return scanner.nextLine();
    }

    @Override
    public List<String> split(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter)).collect(Collectors.toList());
    }
}
