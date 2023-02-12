package view;

import static utils.ErrorMessage.WRONG_TRY_TIMES;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final int MIN_TRY_TIMES = 1;
    private final String CAR_NAME_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        String carNames = scanner.nextLine();
        // TODO: carName 공백 validation
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    public int inputTryTimes() {
        // TODO: tryTimes 숫자 validation
        int tryTimes = scanner.nextInt();
        validateTryTimes(tryTimes);
        return tryTimes;
    }

    private void validateTryTimes(int tryTimes) {
        if (tryTimes < MIN_TRY_TIMES) {
            throw new IllegalArgumentException(WRONG_TRY_TIMES.of());
        }
    }
}
