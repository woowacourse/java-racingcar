package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String TWO_COMMAS = ",,";
    private static final String COMMA = ",";
    private static final String ERROR = "[ERROR] ";
    private static final String TWO_COMMAS_ERROR = ERROR + "2개 이상의 쉼표가 연속으로 올 수 없습니다.";
    private static final String NON_DIGIT_ERROR = ERROR + "숫자만 입력해 주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> scanCarNames() {
        String carNames = scanner.nextLine();

        if (carNames.contains(TWO_COMMAS)) {
            throw new IllegalArgumentException(TWO_COMMAS_ERROR);
        }
        return Arrays.asList(carNames.split(COMMA));
    }

    public int scanTimes() {
        String times = scanner.nextLine();

        try {
            return Integer.parseInt(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_DIGIT_ERROR);
        }
    }
}
