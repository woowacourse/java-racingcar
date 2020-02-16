package racingcar.View;

import java.util.Scanner;

import racingcar.Controller.InputValidation;

/**
 * 클래스 이름 : InputView.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class InputView {
    private static final String DELIMITER = ",";
    private static Scanner sc = new Scanner(System.in);

    public static String[] inputCarName() {
        OutputView.printInputCarNamesMessage();
        String[] carNames = sc.nextLine().split(DELIMITER);
        trimCarNames(carNames);
        if (checkInputCarNameValidation(carNames)) {
            return carNames;
        }
        return inputCarName();
    }

    private static void trimCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private static boolean checkInputCarNameValidation(String[] carNames) {
        try {
            InputValidation.checkWantToTerminate(carNames[0]);
            InputValidation.checkNullOrEmptyInput(carNames);
            InputValidation.checkEmptyCarName(carNames);
            InputValidation.checkSmallerThanSix(carNames);
            return true;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return false;
    }


    public static int inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        String trialTime = sc.nextLine();
        if (checkInputTrialTimeValidation(trialTime)) return Integer.parseInt(trialTime);
        return inputTrialTime();
    }

    private static boolean checkInputTrialTimeValidation(String trialTime) {
        try {
            InputValidation.checkWantToTerminate(trialTime);
            InputValidation.checkDecimalNumber(trialTime);
            InputValidation.checkNotNumber(trialTime);
            InputValidation.checkNegativeAndZeroInput(trialTime);
            InputValidation.checkIntegerOverflow(trialTime);
            return true;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return false;
    }
}
