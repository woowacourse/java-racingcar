package racingcar.domain;

public class StandardRacingRule implements RacingRule{

    private static final int THRESHOLD = 4;

    @Override
    public boolean isMovable(int power) {
        return power >= THRESHOLD;
    }
}
