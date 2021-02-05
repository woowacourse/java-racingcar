package racingcar.domain;

public class Lap {
    public static final int MINIMUM_LAP = 1;
    public static final int UNIT_OF_ONE_LAP = 1;
    public static final int FINISH_FLAG = 0;

    private int lap;

    public Lap(String inputLap) {
        int numberLap = validateNumberLap(inputLap);
        this.lap = validatePositiveLap(numberLap);
    }

    private int validateNumberLap(String inputLap) {
        try {
            return Integer.parseInt(inputLap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
        }
    }

    private int validatePositiveLap(int numberLap) {
        if (numberLap < MINIMUM_LAP) {
            throw new IllegalArgumentException("1 미만의 입력입니다.");
        }
        return numberLap;
    }

    public void finishOneLap() {
        this.lap -= UNIT_OF_ONE_LAP;
    }

    public boolean isFinishAll() {
        return this.lap == FINISH_FLAG;
    }

    public int getLap() {
        return lap;
    }
}
