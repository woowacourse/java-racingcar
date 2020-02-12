package racingcar.Controller;

import java.util.InputMismatchException;

public class InputValidation {

    public static void checkNullOrEmptyInput(String result) {
        if (result == null || result.isEmpty()) {
            throw new NullPointerException("입력이 null 이나 빈 문자열입니다.");
        }
    }

    public static void checkSmallerThanSix(String result) {
        if (result.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 6 이상입니다.");
        }
    }

    public static void checkNegativeAndZeroInput(String trialTime) {
        double value = Double.parseDouble(trialTime);
        if (value <= 0){
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
            int value = Integer.parseInt(trialTime);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다.");
        }
    }
}
