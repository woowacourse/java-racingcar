package service;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber(int maxNumber) {
        return (int) (Math.random() * maxNumber);
    }
}
