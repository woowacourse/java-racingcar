package racingcar.dto;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.internal.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameRoundRequestTest {
    @DisplayName("게임 라운드 정상 입력 테스트")
    @ParameterizedTest(name = "정상 입력 = {0}")
    @ValueSource(strings = {"1", "10", "1000"})
    void validGameRoundRequestTest(String gameRound) {
        Assertions.assertThat(new GameRoundRequest(gameRound)).isNotNull();
    }

    @DisplayName("게임 라운드 예외 입력 테스트")
    @ParameterizedTest(name = "예외 입력 = {0}")
    @ValueSource(strings = {" ", "a", "01", "1 0"})
    void exceptionGameRoundRequestTest(String gameRound) {
        Assertions.assertThatThrownBy(() -> new GameRoundRequest(gameRound))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
