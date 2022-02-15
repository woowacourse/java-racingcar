package racingcar.domain.round.condition;

public class RoundCountRange {

    private static final int ALLOWED_MINIMUM = 1;

    private RoundCountRange() {
    }

    public static boolean isTooSmall(int count) {
        return count < ALLOWED_MINIMUM;
    }

}
