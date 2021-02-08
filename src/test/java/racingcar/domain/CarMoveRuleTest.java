package racingcar.domain;

import org.junit.jupiter.api.Test;

public class CarMoveRuleTest implements CarMoveRuleStrategy {
    private static final int MOVE_LIMIT = 3;

    static int number = 3;

    @Override
    public boolean execute() {
        return number++ > MOVE_LIMIT;
    }

    @Test
    public void test() {
        execute();
    }
}
