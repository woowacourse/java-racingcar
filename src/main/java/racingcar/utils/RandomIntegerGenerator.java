package racingcar.utils;

public class RandomIntegerGenerator {
    public static int random(final int start, final int end) {
        return (int) (Math.random() * (end - start)) + start;
    }
}
