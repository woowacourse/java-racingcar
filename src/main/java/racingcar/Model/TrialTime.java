package racingcar.Model;

import java.util.InputMismatchException;

/**
 * 클래스 이름 : TrialTime.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class TrialTime {
    private int trialTime;

    public TrialTime(String trialTime) {
        checkDecimalNumber(trialTime);
        checkNotNumber(trialTime);
        checkNegativeAndZeroInput(trialTime);
        checkIntegerOverflow(trialTime);
        this.trialTime = Integer.parseInt(trialTime);
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

    public int getTrialTime() {
        return this.trialTime;
    }
}
