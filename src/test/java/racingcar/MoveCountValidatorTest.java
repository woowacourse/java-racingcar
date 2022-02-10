package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoveCountValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "가"})
    @DisplayName("입력값이 숫자가 아닐 경우")
    void notIntegerTest(String moveCount) {
        assertThatThrownBy(() -> {
            MoveCountValidator.validateMoveCount(moveCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동횟수는 숫자로 입력해야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("입력값이 양수가 아닐 경우")
    void notPositiveTest(String moveCount) {
        assertThatThrownBy(() -> {
            MoveCountValidator.validateMoveCount(moveCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동횟수는 1 이상의 정수여야 합니다.");
    }
}