package racingcar.util;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    @Override
    public int generate() {
        return (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
    }

}
