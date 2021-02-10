package racingcar.domain.game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("Game 객체의 종료 여부 테스트")
    void notFinished() {
        final Game game = new Game(1);
        assertTrue(game.notFinished());
        game.play();
        assertFalse(game.notFinished());
    }
}