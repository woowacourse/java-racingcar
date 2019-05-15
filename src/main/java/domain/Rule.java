package domain;

import java.util.Random;

public class Rule {
    private static final int BOUND_NUMBER = 10;
    private static final int MIN_MOVE_NUMBER = 4;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }

    public static boolean judgeMove(int number) {
        return number >= MIN_MOVE_NUMBER;
    }
}
