package racingcar.validator;

public class TryCountValidator {
    public void validateTryCount(String tryCount) {
        validateNumeric(tryCount);
    }

    private void validateNumeric(String tryCount) {
        if (tryCount != null && tryCount.matches("[0-9]+") && !tryCount.equals("0")) {
            return;
        }
        throw new IllegalArgumentException("시도할 횟수는 자연수만 가능합니다.");
    }
}