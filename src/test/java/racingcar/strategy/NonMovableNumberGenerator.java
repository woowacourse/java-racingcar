package racingcar.strategy;

public class NonMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 3;
    }
}
