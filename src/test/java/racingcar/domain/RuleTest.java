package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RuleTest {

    @Test
    void 이동가능한숫자일때_이동가능한지_테스트() {
        assertThat(Rule.isPossibleMove(4)).isTrue();
    }

    @Test
    void 이동가능한숫자가_아닐때_이동가능한지_테스트() {
        assertThat(Rule.isPossibleMove(0)).isFalse();
    }
}
