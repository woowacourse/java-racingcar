package racingcar.utils;

public class TrialNumberValidator {
    private static final int MIN_BOUND = 1;
    private static final String EMPTY_STRING = "";
    private static final String EMPTY_INPUT_MESSAGE = "시도 횟수에 빈 문자열은 입력될 수 없습니다.";
    private static final String NOT_POSITIVE_NUMBER_MESSAGE = "시도 횟수가 1 이상이 아닙니다.";
    private static final String NOT_INTEGER_NUMBER_MESSAGE = "시도 횟수에는 정수만 입력할 수 있습니다.";

    public static void isEmpty(String trialNumber) {
        if (trialNumber.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    public static void isNotPositive(int trialNumber) {
        if (trialNumber < MIN_BOUND) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    public static void isNotInteger(String trialNumber) {
        try {
            Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER_MESSAGE);
        }
    }
}
