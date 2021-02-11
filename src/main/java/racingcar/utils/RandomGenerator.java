package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final Random random = new Random();

    private static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }

    public static int[] generateRandomNumbers(int numberOfCars) {
        int[] numbers = new int[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            numbers[i] = generateRandomNumber();
        }
        return numbers;
    }
}
