package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuleTest {

    @Test
    void MOVE_리턴() {
        assertThat(Rule.isMove(4)).isEqualTo(Rule.MOVE);
        assertThat(Rule.isMove(9)).isEqualTo(Rule.MOVE);
    }

    @Test
    void STOP_리턴() {
        assertThat(Rule.isMove(0)).isEqualTo(Rule.STOP);
        assertThat(Rule.isMove(3)).isEqualTo(Rule.STOP);
    }

    @Test
    void 예외리턴() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.isMove(10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.isMove(-1);
        });
    }
}
