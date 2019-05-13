package racingcar.domain.Rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveRuleTest {
    private MoveRule moveRule;

    @BeforeEach
    void setUp() {
        moveRule = new MoveRule();
    }

    @Test
    void 이동_가능() {
        assertThat(moveRule.canMove(4)).isTrue();
    }

    @Test
    void 이동_불가능() {
        assertThat(moveRule.canMove(3)).isFalse();
    }
}
