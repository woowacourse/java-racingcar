package racingcar.domain;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    @Override
    public int generate(){
        return (int) ((Math.random() * (RANGE_MAX - RANGE_MIN)) + RANGE_MIN);
    }

}
