package racingcar.domain;

public class Lap {

    private static final int FINISH = 0;
    private static final int MINIMUM_LAP = 1;
    private static final int LAP_UNIT = 1;

    private final int value;

    private Lap(final String value) {
        this(Integer.parseInt(value));
    }

    private Lap(final int value){
        this.value = value;
    }

    public static Lap initGoalLap(final String goalLap) {
        validatePositiveNumber(goalLap);
        return new Lap(goalLap);
    }

    private static void validatePositiveNumber(final String lap) {
        try {
            validatePositive(Integer.parseInt(lap));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
        }
    }

    private static void validatePositive(final int numberLap) {
        if (numberLap < MINIMUM_LAP) {
            throw new IllegalArgumentException("1 미만의 입력입니다.");
        }
    }

    public Lap passOneLap() {
        return new Lap(value - LAP_UNIT);
    }

    public boolean isFinish() {
        return value == FINISH;
    }

}
