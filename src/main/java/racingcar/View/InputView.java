package racingcar.View;

import racingcar.Controller.InputValidation;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static Scanner sc = new Scanner(System.in);

    public static String[] inputCarName() {
        OutputView.printInputCarNamesMessage();
        String[] carNames = sc.nextLine().split(DELIMITER);
        try {
            InputValidation.checkNullOrEmptyInput(carNames);
            InputValidation.checkSmallerThanSix(carNames);
            return carNames;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return inputCarName();
    }

    public static int inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        String trialTime = sc.nextLine();
        try {
            InputValidation.checkIntegerOverflow(trialTime);
            InputValidation.checkDecimalNumber(trialTime);
            InputValidation.checkNegativeAndZeroInput(trialTime);
            InputValidation.checkNotNumber(trialTime);
            return Integer.parseInt(trialTime);
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return inputTrialTime();
    }
}
