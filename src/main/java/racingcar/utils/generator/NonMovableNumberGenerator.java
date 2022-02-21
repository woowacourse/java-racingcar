package racingcar.utils.generator;

public class NonMovableNumberGenerator implements NumberGenerator {
    @Override
    public boolean canForward() {
        return false;
    }
}
