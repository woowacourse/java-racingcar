package racingcar.model;

public class Random {
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int MIN_RANDOM_NUMBER = 1;
    private final static int POSSIBLE_MOVE = 4;

    public static boolean isEnableGo() {
        return ((int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER) >= POSSIBLE_MOVE;
    }
}
