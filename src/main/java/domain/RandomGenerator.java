package domain;

public class RandomGenerator implements NumberGenerator {

    private static final int CAR_MOVE_RANGE = 10;

    @Override
    public int generate() {
        return (int) (Math.random() * CAR_MOVE_RANGE);
    }
}
