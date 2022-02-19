package racingcar.domain.round.condition;

public enum RoundCount {

    ALLOWED_MINIMUM_COUNT(1);

    private final int count;

    RoundCount(final int count) {
        this.count = count;
    }

    public static boolean isTooSmall(final int count) {
        return count < ALLOWED_MINIMUM_COUNT.count;
    }

}
