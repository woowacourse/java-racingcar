package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GameRoundRequestTest {
    @DisplayName("GameRound 입력 후 DTO 바인딩 시 정상 테스트")
    @ParameterizedTest(name = "inputGameRound = {0}")
    @ValueSource(strings = {"2", "10", "100", "1000000"})
    void gameRoundRequestInputTest(String inputGameRound) {
        GameRoundRequest gameRoundRequest = new GameRoundRequest(inputGameRound);
        assertThat(gameRoundRequest.getRound()).isEqualTo(Integer.parseInt(inputGameRound));
    }

    @DisplayName("GameRound 입력 후 DTO 바인딩 시 타입 불일치 예외 테스트")
    @ParameterizedTest(name = "inputGameRound = {0}")
    @ValueSource(strings = {"다섯번", "5.0", "5 0"})
    void gameRoundRequestTypeMismatchExceptionTest(String inputGameRound) {
        assertThatThrownBy(() -> new GameRoundRequest(inputGameRound)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("GameRound 입력 후 DTO 바인딩 시 값이 0으로 시작하거나 0인 예외 테스트")
    @ParameterizedTest(name = "inputGameRound = {0}")
    @ValueSource(strings = {"005", "0"})
    void gameRoundRequestZeroStartExceptionTest(String inputGameRound) {
        assertThatThrownBy(() -> new GameRoundRequest(inputGameRound)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("GameRound 입력 후 DTO 바인딩 시 공백 예외 테스트")
    @ParameterizedTest(name = "inputGameRound = {0}")
    @NullAndEmptySource
    void gameRoundRequestBlankExceptionTest(String inputGameRound) {
        assertThatThrownBy(() -> new GameRoundRequest(inputGameRound)).isInstanceOf(IllegalArgumentException.class);
    }
}
