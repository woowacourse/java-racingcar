package racingcar.domain;

import org.junit.jupiter.api.Test;

public class RuleTest implements RuleStrategy {
    static int number;

    @Override
    public boolean execute() {
        return  5 > MOVE_LIMIT;
    }

    @Test
    public void test() {
        execute();
    }
}
