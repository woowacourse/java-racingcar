package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
public class RacingGameTest {

    @Test
    void 게임_종료_성공() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{"jae"}), 1, new RandomNumberGenerator());
        racingGame.playTurn();

        assertTrue(racingGame.isFinished());
    }

}