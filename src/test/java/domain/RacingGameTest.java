package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    RacingGame game;

    @BeforeEach
    void setUp() {
        game = new RacingGame();
    }

    @Test
    void 이름입력() {
    }

    @Test
    void 위치출력() {
        game.printPositionByRound();
    }
}
