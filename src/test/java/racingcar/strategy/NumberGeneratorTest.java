package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    public static final int MOVE_CONDITION = 4;

    @DisplayName("MovableNumberGenerator 테스트")
    @Test
    public void MovableNumberGenerator_test() throws Exception {
        MovableNumberGenerator generator = new MovableNumberGenerator();
        assertThat(generator.generate()).isGreaterThanOrEqualTo(MOVE_CONDITION);
    }

    @DisplayName("NonMovableNumberGenerator 테스트")
    @Test
    public void NonMovableNumberGenerator_test() throws Exception {
        NonMovableNumberGenerator generator = new NonMovableNumberGenerator();
        assertThat(generator.generate()).isLessThan(MOVE_CONDITION);
    }
}
