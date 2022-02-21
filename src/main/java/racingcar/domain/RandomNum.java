package racingcar.domain;

public class RandomNum {
    private static final int RANDOM_MAX_RANGE = 10;
    private static final java.util.Random random = new java.util.Random();

    public static int getRandomNum() {
        return random.nextInt(RANDOM_MAX_RANGE);
    }
}
