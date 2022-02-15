package racingcar.domain.car.condition;

public enum ForwardCondition {

    ALLOWED_MINIMUM_RANGE(4);

    private final int range;

    ForwardCondition(int range) {
        this.range = range;
    }

    public static boolean isInRange(int number) {
        return number >= ALLOWED_MINIMUM_RANGE.range;
    }

}
