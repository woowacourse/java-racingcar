package racingcar.util;

public class NonMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return MovementUtil.getMoveCondition() - 1;
    }
}
