package racingcar.domain.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("Game 객체 생성 테스트")
    void create() {
        assertEquals(new Game(5), new Game("5"));
    }

    @Test
    @DisplayName("Game 객체의 종료 여부 테스트")
    void notFinished() {
        Game game = new Game(1);
        assertTrue(game.notFinished());
        game.play();
        assertFalse(game.notFinished());
    }
}