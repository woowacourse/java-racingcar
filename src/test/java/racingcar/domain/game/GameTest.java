package racingcar.domain.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void notFinished() {
        Game testingGame = new Game(1);
        assertTrue(testingGame.notFinished());
        testingGame.incrementCount();
        assertFalse(testingGame.notFinished());
    }
}