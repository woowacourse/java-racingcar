package racingcar.View;

import racingcar.Controller.InputValidation;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static Scanner sc = new Scanner(System.in);

    public static String[] inputCarName() {
        String[] carNames = sc.nextLine().split(DELIMITER);
        try {
            InputValidation.checkNullOrEmptyInput(carNames);
            InputValidation.checkSmallerThanSix(carNames);
            return carNames;
        } catch (NullPointerException e) {
            OutputView.printExceptionMessage(e);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
        }
        return inputCarName();
    }
}
