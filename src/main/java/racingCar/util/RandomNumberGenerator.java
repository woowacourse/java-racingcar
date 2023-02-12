package racingCar.util;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_RANGE = 0;
    private static  final int MAX_RANGE = 9;

    @Override
    public int generateNumber() {
        return (int)(Math.random() * (MAX_RANGE - MIN_RANGE)) + MIN_RANGE;
    }
}
