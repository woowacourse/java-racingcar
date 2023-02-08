package racingcar;

import java.util.Random;

public class RandomMaker {

    public static int random() {
        Random random = new Random();

        return random.nextInt(9);
    }
}
