package racingcar.utils;

public class TrialNumberValidator {
    private static final int MIN_BOUND = 1;
    private static final String EMPTY_INPUT_MESSAGE = "시도 횟수에 빈 문자열은 입력될 수 없습니다.";
    private static final String NOT_POSITIVE_NUMBER_MESSAGE = "시도 횟수가 1 이상이 아닙니다.";
    private static final String NOT_INTEGER_NUMBER_MESSAGE = "시도 횟수에는 정수만 입력할 수 있습니다.";

    public static void validate(String trialNumber) {
        checkEmpty(trialNumber);
        checkNotInteger(trialNumber);
        checkNotPositive(Integer.parseInt(trialNumber));
    }

    private static void checkEmpty(String trialNumber) {
        if (isEmpty(trialNumber)) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private static boolean isEmpty(String trialNumber) {
        return trialNumber.isEmpty() || trialNumber.isBlank();
    }

    private static void checkNotPositive(int trialNumber) {
        if (trialNumber < MIN_BOUND) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private static void checkNotInteger(String trialNumber) {
        try {
            Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER_MESSAGE);
        }
    }
}
