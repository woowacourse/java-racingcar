package racingcar.domain.car.condition;

public class ForwardCondition {

    private static final int STANDARD_TO_GO_FORWARD = 4;

    private ForwardCondition() {
    }

    public static boolean isSatisfied(final int number) {
        return number >= STANDARD_TO_GO_FORWARD;
    }

}
