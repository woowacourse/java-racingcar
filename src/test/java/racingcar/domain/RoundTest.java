package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @DisplayName("Round에 대한 입력이 1 이상이 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void checkIsValidRound(int inputNumber) {
        assertThatThrownBy(() -> Round.create(inputNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
