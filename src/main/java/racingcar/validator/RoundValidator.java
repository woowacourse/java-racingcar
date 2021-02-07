package racingcar.validator;

public class RoundValidator {
    private static final int MIN_COUNT_SIZE = 1;

    private RoundValidator() {}

    public static void validateRoundCount(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new IllegalArgumentException("시도할 횟수는 1이상 이어야 합니다.");
        }
    }
}
