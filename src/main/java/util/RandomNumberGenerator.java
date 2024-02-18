package util;

public class RandomNumberGenerator {

    public static int generate() {
        int minNumber = Constants.MIN_RANDOM_NUMBER;
        int maxNumber = Constants.MAX_RANDOM_NUMBER;

        return (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);
    }

}
