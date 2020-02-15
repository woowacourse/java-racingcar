package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {10,-1})
    void ThrowError_When_MoveNumber_IsNotValidRange(int moveNumber) {
        assertThatThrownBy(() -> new MoveNumber(moveNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,9})
    void Not_ThrowError_When_MoveNumber_IsValidRange(int moveNumber) {
        assertThatCode(() -> new MoveNumber(moveNumber)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,9})
    void ReturnTrue_When_isMovable(int moveNumber) {
        assertThat(new MoveNumber(moveNumber).isMovable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    void ReturnFalse_When_isNotMovable(int moveNumber) {
        assertThat(new MoveNumber(moveNumber).isMovable()).isFalse();
    }
}
