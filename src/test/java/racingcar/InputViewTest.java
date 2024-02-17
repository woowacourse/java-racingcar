package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

        @Test
        @DisplayName("콤마를 기준으로 문자열 분리")
        void testParseWithComma() {
            String given = "차1, 차2";
            
            List<String> actual = List.of("차1", "차2");
            List<String> expected = InputView.parseWithComma(given);

            assertThat(actual).isEqualTo(expected);
        }
    }
}
