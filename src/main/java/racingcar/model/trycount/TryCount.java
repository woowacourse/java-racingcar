package racingcar.model.trycount;

public class TryCount {
    private static final int POSITIVE_STANDARD = 0;
    private static final String NUMBER_PATTERN = "[-]?[0-9]+";

    private final int tryCount;

    public TryCount(final String tryCount) {
        validateStringIsNumber(tryCount);
        int tryCountNumber = Integer.parseInt(tryCount);
        validateIsPositive(tryCountNumber);
        this.tryCount = tryCountNumber;
    }

    public static void validateStringIsNumber(final String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("시도할 회수은 숫자여야 합니다.");
        }
    }

    public static void validateIsPositive(final int input) {
        if (input <= POSITIVE_STANDARD) {
            throw new IllegalArgumentException("시도할 회수는 양수여야 합니다.");
        }
    }

    public int value() {
        return tryCount;
    }
}
