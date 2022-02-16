package racingcar.domain.util;

public class Random {
    private static final java.util.Random RANDOM = new java.util.Random();

    public static int makeRandomValue(int bound) {
        return RANDOM.nextInt(bound + 1);
    }
}
