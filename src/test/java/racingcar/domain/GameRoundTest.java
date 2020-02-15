package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void Not_Throw_When_isValid_GameRound(String gameRound) {
        Assertions.assertThatCode(() -> new GameRound(gameRound)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3", "-5"})
    void Throw_When_Not_Valid_GameRound(String gameRound) {
        Assertions.assertThatThrownBy(() -> new GameRound(gameRound))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "-3.1", "5.2"})
    void Throw_When_Not_Integer_GameRound(String gameRound) {
        Assertions.assertThatThrownBy(() -> new GameRound(gameRound))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
