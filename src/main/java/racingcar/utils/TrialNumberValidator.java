package racingcar.utils;

public class TrialNumberValidator {
    private static final int MIN_BOUND = 1;

    public static void isEmpty(String trialNumber) {
        if (trialNumber.equals("")) {
            throw new IllegalArgumentException("시도 횟수가 빈 문자열 입니다.");
        }
    }

    public static void isNotPositive(int trialNumber) {
        if (trialNumber < MIN_BOUND) {
            throw new IllegalArgumentException("시도 횟수가 1 이상이 아닙니다.");
        }
    }

    public static void isNotInteger(String trialNumber) {
        try {
            Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에는 정수만 입력할 수 있습니다.");
        }
    }
}
