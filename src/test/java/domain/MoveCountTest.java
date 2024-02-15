package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 이동 횟수 도메인 테스트")
class MoveCountTest {

    @DisplayName("자동차 이동 횟수가 음수이거나 0일 경우 도메인이 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -333})
    void testCreateMoveCountWithInvalidValue(int moveCount) {
        assertThatThrownBy(() -> MoveCount.from(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 횟수가 양의 정수일 경우 도메인이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void testCreateMoveCountWithValidValue(int moveCount) {
        assertThatCode(() -> MoveCount.from(moveCount)).doesNotThrowAnyException();
    }

    @DisplayName("움직일 수 있는 횟수를 차감할 수 있다")
    @Test
    void testConsumeCount() {
        MoveCount moveCount = MoveCount.from(1);
        moveCount.consume();
        assertThat(moveCount.isCountZero()).isTrue();
    }

    @DisplayName("움직일 수 있는 횟수가 0인지 체크할 수 있다")
    @Test
    void testDetectCountZero() {
        MoveCount moveCount = MoveCount.from(1);
        moveCount.consume();
        assertThat(moveCount.isCountZero()).isTrue();
    }

    @DisplayName("움직일 수 있는 횟수가 0이 아닌지 체크할 수 있다.")
    @Test
    void testDetectCountNonZero() {
        MoveCount moveCount = MoveCount.from(1);
        assertThat(moveCount.isCountZero()).isFalse();
    }
}