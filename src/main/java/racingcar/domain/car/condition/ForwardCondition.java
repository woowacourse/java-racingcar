package racingcar.domain.car.condition;

public enum ForwardCondition {

    MINIMUM(4);

    private final int number;

    ForwardCondition(int number) {
        this.number = number;
    }

    public static boolean isInRange(int number) {
        return (number >= MINIMUM.number);
    }

}
