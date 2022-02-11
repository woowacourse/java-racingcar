package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.MoveCountValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.validator.MoveCountValidator.*;

class MoveCountValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "가"})
    @DisplayName("입력값이 숫자가 아닐 경우")
    void notIntegerTest(String moveCount) {
        assertThatThrownBy(() -> {
            validateMoveCount(moveCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NOT_INTEGER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("입력값이 양수가 아닐 경우")
    void notPositiveTest(String moveCount) {
        assertThatThrownBy(() -> {
            validateMoveCount(moveCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NOT_POSITIVE);
    }
}