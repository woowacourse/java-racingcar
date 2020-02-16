package racingcar.domain;

public class RandomNumber {
    public static final int MIN_RANDOM_NUMBER = 0;
    private static final int MOVE_FORWARD = 4;
    public static final int MAX_RANDOM_NUMBER = 9;
    private int randomNumber;

    public RandomNumber(int randomNumber) {
        if (randomNumber < MIN_RANDOM_NUMBER || randomNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("만들어진 randomNumber 가 유효하지 않습니다.");
        }
        this.randomNumber = randomNumber;
    }

    boolean isMove() {
        return randomNumber >= MOVE_FORWARD;
    }
}
