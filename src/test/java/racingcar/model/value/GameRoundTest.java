package racingcar.model.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameRoundTest {
    @Test
    @DisplayName("gameRound 객체 생성 성공")
    public void successCreateGameRound() {
        // given
        GameRound gameRound = GameRound.fromString("1");

        // when
        // then
        assertThat(gameRound).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1"})
    @DisplayName("gameRound는 문자거나 음수일 수 없다")
    public void failCreateGameRound(String tryCountString) {
        assertThatThrownBy(() -> GameRound.fromString(tryCountString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,true"})
    @DisplayName("totalRound 만큼 게임을 진행하면 continuable()은 false를 반환한다.")
    public void continuableTest(String input, boolean expected) {
        // given
        GameRound gameRound = GameRound.fromString(input);

        // when
        gameRound.proceed();

        // then
        assertThat(gameRound.continuable()).isEqualTo(expected);
    }
}