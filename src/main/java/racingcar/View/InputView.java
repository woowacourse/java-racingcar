package racingcar.View;

import racingcar.Controller.InputValidation;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static Scanner sc = new Scanner(System.in);

    public static String[] inputCarName() {
        OutputView.printInputCarNamesMessage();
        String[] carNames = sc.nextLine().split(DELIMITER); // TODO 스페이스바만 입력했을때 ,로 끝났을 경우 어떻게 해야 할까용
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
