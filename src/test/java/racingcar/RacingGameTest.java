package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
