package racingcar.domain;

public class Lap {

    private static final int INIT_LAP = 0;
    private static final int MINIMUM_LAP = 1;
    private static final int UNIT_OF_ONE_LAP = 1;

    private final int goalLap;
    private int currentLap;

    public Lap(final String inputLap) {
        this.goalLap = validatePositiveNumber(inputLap);
        this.currentLap = INIT_LAP;
    }

    private int validatePositiveNumber(final String inputLap) {
        try {
            return validatePositive(Integer.parseInt(inputLap));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
        }
    }

    private int validatePositive(final int numberLap) {
        if (numberLap < MINIMUM_LAP) {
            throw new IllegalArgumentException("1 미만의 입력입니다.");
        }
        return numberLap;
    }

    public void passOneLap() {
        currentLap += UNIT_OF_ONE_LAP;
    }

    public boolean isFinish() {
        return currentLap == goalLap;
    }

}
