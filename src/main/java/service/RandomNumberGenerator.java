package service;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber(final int maxNumber) {
        return (int) (Math.random() * maxNumber);
    }
}
