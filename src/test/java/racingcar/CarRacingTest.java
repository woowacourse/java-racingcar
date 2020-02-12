package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void validatePositiveNumber(int negativeNumber) {
        assertThatThrownBy(() -> {
            CarRacing.validatePositiveNumber(negativeNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarRacing.POSITIVE_CRITERIA + "이상의 수를 입력해야합니다.");
    }
}