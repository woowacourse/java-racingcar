package racing.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingMaxTurnInputManagerTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "100"})
    @DisplayName("정상 동작 테스트")
    void getMaxTurn(String input) {
        int maxTurn = RacingMaxTurnInputManager.getMaxTurn(input);
        Assertions.assertThat(String.valueOf(maxTurn))
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "!", "b", " 100"})
    @DisplayName("숫자 아닌 경우 확인")
    void getMaxTurnFailByNotNumber(String input) {
        Assertions.assertThatThrownBy(() -> RacingMaxTurnInputManager.getMaxTurn(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"101", "0", "-1"})
    @DisplayName("허용된 숫자 범위를 벗어난 경우")
    void getMaxTurnFailByOutOfRange(String input) {
        Assertions.assertThatThrownBy(() -> RacingMaxTurnInputManager.getMaxTurn(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
    }
}