package util;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    @Override
    public int generateRandomNumber(int maxNumber) {
        return (int) (Math.random() * maxNumber);
    }
}
