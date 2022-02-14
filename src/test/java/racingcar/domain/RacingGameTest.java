package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.StubNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    @Test
    void 시도_회수_감소() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{"jae"}), 1, new StubNumberGenerator());
        racingGame.playTurn();

        assertTrue(racingGame.isFinished());
    }

}