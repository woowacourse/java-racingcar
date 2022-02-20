package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovePredicateTest {
    @Test
    @DisplayName("4 이상의 값일 때 true 반환")
    void test_5() {
        MovePredicate movePredicate = new MovePredicate();
        assertThat(movePredicate.test(5)).isTrue();
    }

    @Test
    @DisplayName("4 미만의 값일 때 false 반환")
    void test_3() {
        MovePredicate movePredicate = new MovePredicate();
        assertThat(movePredicate.test(3)).isFalse();
    }
}
