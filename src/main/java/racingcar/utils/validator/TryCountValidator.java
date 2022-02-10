package racingcar.utils.validator;

public class TryCountValidator {
    private static final String PATTERN = "^([1-9])([0-9])*$";
    private static final String PATTERN_ERROR_MESSAGE = "[ERROR] 시도 회수는 양수만 가능합니다.";

    private TryCountValidator() {}

    public static boolean isValidated(String inputTryCount) {
        try {
            validatePattern(inputTryCount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void validatePattern(String inputTryCount) {
        if (!inputTryCount.matches(PATTERN)) {
            throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
        }
    }
}
