package racingcar.Controller;

import racingcar.Util.StringUtils;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.InputMismatchException;
import java.util.List;

/**
 * 클래스 이름 : InputValidation.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class InputValidation {
    public static List<String> validateInputCarName(String carNameInput) {
        List<String> carNames = StringUtils.splitCarNames(carNameInput);
        carNames = StringUtils.trimCarNames(carNames);
        try {
            checkNullOrEmptyInput(carNames);
            checkEmptyCarName(carNames);
            checkSmallerThanSix(carNames);
            return carNames;
        } catch (Exception e) {
            OutputView.printExceptionMessage(e);
        }
        return InputView.inputCarName();
    }

    public static void checkNullOrEmptyInput(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new NullPointerException("입력이 null 이나 빈 문자열입니다.");
        }
    }

    public static void checkEmptyCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }

    public static void checkSmallerThanSix(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이가 6 이상입니다.");
            }
        }
    }

    public static void checkNegativeAndZeroInput(String trialTime) {
        double value = Double.parseDouble(trialTime);
        if (value <= 0) {
            throw new IllegalArgumentException("음수 또는 0을 입력할 수 없습니다.");
        }
    }

    public static void checkIntegerOverflow(String trialTime) {
        double value = Double.parseDouble(trialTime);
        if (value > Integer.MAX_VALUE) {
            throw new ArithmeticException("입력 범위를 초과했습니다.");
        }
    }

    public static void checkDecimalNumber(String trialTime) {
        if (trialTime.contains(".")) {
            throw new InputMismatchException("소수는 입력할 수 없습니다.");
        }
    }

    public static void checkNotNumber(String trialTime) {
        try {
            double value = Double.parseDouble(trialTime);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("문자는 입력할 수 없습니다.");
        }
    }
}
