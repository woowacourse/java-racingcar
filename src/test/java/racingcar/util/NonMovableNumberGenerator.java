package racingcar.util;

public class NonMovableNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate() {
        return 1;
    }
}
