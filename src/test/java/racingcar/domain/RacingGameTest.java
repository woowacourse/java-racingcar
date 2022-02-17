package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.StubNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
public class RacingGameTest {

    @Test
    void 게임_진행_성공() {
        StubNumberGenerator stubNumberGenerator = new StubNumberGenerator();
        stubNumberGenerator.prepareStubNumbers(1, 4);

        RacingGame racingGame = new RacingGame(new Cars(new String[]{"jae"}), 1, stubNumberGenerator);
        racingGame.playTurn();

        List<Car> cars = racingGame.getCars().getCars();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 게임_종료_성공() {
        RacingGame racingGame = new RacingGame(new Cars(new String[]{"jae"}), 1, new RandomNumberGenerator());
        racingGame.playTurn();

        assertTrue(racingGame.isFinished());
    }

}