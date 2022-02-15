package racingcar.domain.trycount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TryCountTest {
    @DisplayName("from 메소드에 정상 숫자를 전달하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "11"})
    void fromWithValidInput(String input) {
        assertDoesNotThrow(() -> TryCount.from(input));
    }

    @DisplayName("from 메소드에 숫자가 아닌 문자를 전달하면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "", "12a", "-"})
    void fromWithNotNumber(String input) {
        assertThatThrownBy(() -> TryCount.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("from 메소드에 양수가 아닌 숫자를 전달하면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-22"})
    void fromWithNotPositive(String input) {
        assertThatThrownBy(() -> TryCount.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
