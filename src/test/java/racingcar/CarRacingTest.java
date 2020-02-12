package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingTest {
    @ParameterizedTest
    @ValueSource(ints ={-1, 0})
    void validatePositiveNumber(int negativeNumber) {
        assertThatThrownBy(() -> {
            CarRacing.validatePositiveNumber(negativeNumber);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("2이상의 수를 입력해야합니다.");
    }
}