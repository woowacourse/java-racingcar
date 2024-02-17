package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Nested
    class ValidateInput {
        @ParameterizedTest
        @ValueSource(strings = {",포케", "폭포,"})
        @DisplayName("콤마가 맨 앞 또는 맨 뒤에 위치하면 에러 발생")
        void testIfValidInput(String given) {
            assertThatThrownBy(() -> InputView.checkIfValidInput(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
