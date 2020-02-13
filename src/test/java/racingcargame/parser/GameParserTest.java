package racingcargame.parser;

import org.junit.jupiter.api.Test;
import racingcargame.domain.TrialTimes;
import racingcargame.game.CarRace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameParserTest {

    @Test
    void carRaceModel() {
        CarRace carRace = GameParser.generateCarRace("제이,라테,포비");
        assertThat(carRace);
    }

    @Test
    void trialTimes() {
        TrialTimes trialTimes = GameParser.generateTrialTimes("2");
        assertThat(trialTimes);
    }


    @Test
    void createTrialTimesWithNotNumber() {
        assertThatThrownBy(() -> GameParser.generateTrialTimes("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}