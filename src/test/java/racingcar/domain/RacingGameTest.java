package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    @Test
    void 시도_회수_감소() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{"jae"}), 1, new RandomNumberGenerator());
        racingGame.playTurn();

        assertTrue(racingGame.isFinished());
    }

}