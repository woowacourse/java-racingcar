package racingcar.domain;

public class MovingWithNumberRange implements MovingStrategy {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean movable() {
        return RandomNumber.getRandomNumber() >= MOVE_THRESHOLD;
    }
}
