package racingcar.domain;

import org.junit.jupiter.api.Test;

public class RandomNumberRuleTest implements RandomNumberRuleStrategy {
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
