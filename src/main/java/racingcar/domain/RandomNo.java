package racingcar.domain;

public class RandomNo {
    private static final int MOVE_FORWARD = 4;
    int randomNumber;

    public RandomNo(int randomNo) {
        if (randomNo < 0 || randomNo > 9) {
            throw new IllegalArgumentException();
        }
        randomNumber = randomNo;
    }

    boolean isMove() {
        return randomNumber >= MOVE_FORWARD;
    }
}
