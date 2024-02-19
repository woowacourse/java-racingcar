package util;

public class RandomNumberGenerator {

    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_RANDOM_NUMBER = 0;


    public static int generate() {
        int minNumber = MIN_RANDOM_NUMBER;
        int maxNumber = MAX_RANDOM_NUMBER;

        return (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);
    }

}
