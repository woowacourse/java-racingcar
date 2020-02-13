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
        String[] carNames = inputCarNameWithConsole().split(DELIMITER);
        trimCarNames(carNames);
        try {
            InputValidation.checkEmptyCarName(carNames);
            InputValidation.checkSmallerThanSix(carNames);
            return carNames;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return inputCarName();
    }

    private static String inputCarNameWithConsole() {
        String inputValue = sc.nextLine();
        try {
            InputValidation.checkNullOrEmptyInput(inputValue);
            return inputValue;
        } catch (NullPointerException e){
            OutputView.printExceptionMessage(e);
        }
        return inputCarNameWithConsole();
    }

    private static void trimCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    public static int inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        String trialTime = sc.nextLine();
        try {
            InputValidation.checkDecimalNumber(trialTime);
            InputValidation.checkNotNumber(trialTime);
            InputValidation.checkNegativeAndZeroInput(trialTime);
            InputValidation.checkIntegerOverflow(trialTime);
            return Integer.parseInt(trialTime);
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return inputTrialTime();
    }
}
