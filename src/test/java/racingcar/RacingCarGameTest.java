package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame();
    }

    @Test
    void getWinners() {
        List<String> winners = racingCarGame.getWinners();

    }
}