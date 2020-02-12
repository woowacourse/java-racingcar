package racingcargame.model;

import org.junit.jupiter.api.Test;
import racingcargame.game.CarRace;

import static org.assertj.core.api.Assertions.assertThat;

class GameModelTest {

    @Test
    void carRaceModel() {
        CarRace carRace = GameModel.generateCarRace("제이,라테,포비");
        assertThat(carRace);
    }
}