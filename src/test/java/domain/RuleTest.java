package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RuleTest {
    @Test
    void getRandomNumber() {
        assertThat((0 <= Rule.getRandomNumber())
                && (Rule.getRandomNumber() <= 9)).isTrue();
    }

    @Test
    void judgeMove() {
        assertThat(Rule.judgeMove(3)).isFalse();
        assertThat(Rule.judgeMove(4)).isTrue();
    }
}
