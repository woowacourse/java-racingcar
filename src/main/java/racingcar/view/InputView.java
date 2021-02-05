package racingcar.view;

import racingcar.constant.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> scanCarNames() {
        String carNames = scanner.nextLine();

        if (carNames.contains(Message.TWO_COMMAS.toString())) {
            throw new IllegalArgumentException(Message.TWO_COMMAS_ERROR.toString());
        }

        return Arrays.asList(carNames.split(Message.COMMA.toString()));
    }

    public int scanTimes() {
        String times = scanner.nextLine();

        try {
            return Integer.parseInt(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NON_DIGIT_ERROR.toString());
        }
    }
}
