package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int NUMBER_POSSIBLE_TO_GO = 4;
    public static final String ERR_OUT_OUT_BOUND_RANDOM_NUMBER = "범위(0~9) 밖의 랜덤 값입니다.";

    private int randomNumber;
    private Random random = new Random();

    public RandomNumber() {
        this.randomNumber = generateRandomNumber();
        validateRandomNumber(randomNumber);
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER + 1);
    }

    void validateRandomNumber(int randomNumber) {
        if (randomNumber < MIN_RANDOM_NUMBER || randomNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException(ERR_OUT_OUT_BOUND_RANDOM_NUMBER);
        }
    }

    public static boolean canMove(int randomNo) {
        return randomNo >= NUMBER_POSSIBLE_TO_GO;
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}
