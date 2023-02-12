package view;

import static utils.ErrorMessage.WRONG_NAME_CONTAINS_BLANK;
import static utils.ErrorMessage.WRONG_TRY_TIMES_RANGE;
import static utils.ErrorMessage.WRONG_TRY_TIMES_TYPE;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final int MIN_TRY_TIMES = 1;
    private final String CAR_NAME_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        String carNames = scanner.nextLine();
        validateContainsBlank(carNames);
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    public int inputTryTimes() {
        String tryTimes = scanner.nextLine();
        validateTryTimesType(tryTimes);
        validateTryTimesRange(Integer.parseInt(tryTimes));
        return Integer.parseInt(tryTimes);
    }

    private void validateTryTimesRange(int tryTimes) {
        if (tryTimes < MIN_TRY_TIMES) {
            throw new IllegalArgumentException(WRONG_TRY_TIMES_RANGE.of());
        }
    }

    private void validateContainsBlank(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException(WRONG_NAME_CONTAINS_BLANK.of());
        }
    }

    private void validateTryTimesType(String tryTimes) {
        for (char element : tryTimes.toCharArray()) {
            checkDigit(element);
        }
    }

    private void checkDigit(char element) {
        if (!Character.isDigit(element)) {
            throw new IllegalArgumentException(WRONG_TRY_TIMES_TYPE.of());
        }
    }
}
