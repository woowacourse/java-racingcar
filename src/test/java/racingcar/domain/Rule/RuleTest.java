package racingcar.domain.Rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {
    @Test
    void 이동_가능() {
        Rule rule = new MoveRule(4);

        assertThat(rule.canMove()).isTrue();
    }

    @Test
    void 이동_불가능() {
        Rule rule = new MoveRule(3);

        assertThat(rule.canMove()).isFalse();
    }
}
