package domain;

public class Racing {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int MOVE_FORWARD_LOWER_BOUND = 3;

    private static Integer generateRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BOUND);
    }

    public static boolean isMoveForward() {
        int number = generateRandomNumber();
        return number > MOVE_FORWARD_LOWER_BOUND;
    }
}
