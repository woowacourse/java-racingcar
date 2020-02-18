package racingCar.domain;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int TEN = 10;

    RandomNumberGenerator() {
    }

    @Override
    public int generateNumber() {
        return (int) (Math.random() * TEN);
    }
}
