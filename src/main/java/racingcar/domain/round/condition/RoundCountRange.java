package racingcar.domain.round.condition;

public enum RoundCountRange {

    ALLOWED_MINIMUM_COUNT(1);

    private final int count;

    RoundCountRange(int count) {
        this.count = count;
    }

    public static boolean isTooSmall(int count) {
        return (count < ALLOWED_MINIMUM_COUNT.count);
    }

}
