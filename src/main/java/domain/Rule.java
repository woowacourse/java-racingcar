package domain;

import java.util.Random;

public class Rule {
    private static final int BOUND_NUMBER = 10;
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_MOVE_NUMBER = 9;
    private static final int MIN_STOP_NUMBER = 0;

    public static int judgeMove(int number) {
        if (number > MAX_MOVE_NUMBER || number < MIN_STOP_NUMBER) {
            throw new IllegalArgumentException("잘못된 randomNumber");
        }
        if (number >= MIN_MOVE_NUMBER) {
            return 1;
        }
        return 0;
    }

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }
}
