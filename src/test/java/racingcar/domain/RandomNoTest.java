package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNoTest {

    @ParameterizedTest
    @ValueSource(ints = {10,-1})
    void ThrowError_When_RandomNumber_IsNotValidRange(int randomNumber) {
        assertThatThrownBy(() -> new RandomNo(randomNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,9})
    void Not_ThrowError_When_RandomNumber_IsValidRange(int randomNumber) {
        assertThatCode(() -> new RandomNo(randomNumber)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,9})
    void ReturnTrue_When_isMovable(int randomNumber) {
        assertThat(new RandomNo(randomNumber).isMovable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    void ReturnFalse_When_isNotMovable(int randomNumber) {
        assertThat(new RandomNo(randomNumber).isMovable()).isFalse();
    }
}
