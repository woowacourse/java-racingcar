package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {

        racingGame = new RacingGame(new String[]{"Eden"}, 3);
    }
    @Test
    public void startRacing() {
        List<RoundResult> roundResults = racingGame.startRacing();
        assertThat(roundResults.size()).isEqualTo(3);
    }

    @Test
    public void findRacingWinners() {
        List<Car> racingWinners = racingGame.findRacingWinners();
        assertThat(racingWinners.get(0).getName()).isEqualTo("Eden");
    }

}