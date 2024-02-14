package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 이동 횟수 도메인 테스트")
class MoveCountTest {

    @DisplayName("자동차 이동 횟수가 음수일 경우 도메인이 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -333})
    void testCreateMoveCountWithInvalidValue(int moveCount) {
        assertThatThrownBy(() -> MoveCount.from(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 횟수가 음수가 아닐일 경우 도메인이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 5})
    void testCreateMoveCountWithValidValue(int moveCount) {
        assertThatCode(() -> MoveCount.from(moveCount)).doesNotThrowAnyException();
    }
}