package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.Calculator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름과 시도횟수를 받아 게임을 생성한다.")
    void createRacingGame() {
        RacingGame game = new RacingGame("pobi,crong,honux", 5);
        List<String> carNames = game.getCarNames();
        assertAll(
            () -> assertThat(carNames).containsExactly("pobi", "crong", "honux"),
            () -> assertThat(game.getLeftCount()).isEqualTo(5)
        );
    }

    @Test
    @DisplayName("게임이 종료되었는지 확인한다.")
    void checkGameEnd() {
        RacingGame game = new RacingGame("pobi,crong,honux", 5);
        game.start();
        assertTrue(game.isEnd());
    }

    @Test
    @DisplayName("게임이 종료되지 않았는지 확인한다.")
    void checkGameNotEnd() {
        RacingGame game = new RacingGame("pobi,crong,honux", 5);
        assertFalse(game.isEnd());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("게임을 생성할 때 시도횟수가 0이하이면 예외가 발생한다.")
    void nagativeCount(int count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingGame("pobi,crong,honux", count))
            .withMessageMatching("시도횟수는 0이하의 값이 들어올 수 없다.");
    }
}
