package racingcar;


import java.util.Random;

public class RandomGenerator {

    public static int getRandomNumberInRange(int end) {
        Random random = new Random();
        return random.nextInt(end + 1);
    }
}
