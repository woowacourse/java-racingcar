package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    RaceController raceController = new RaceController();

    @Test
    public void 자동차_저장_확인() {
        raceController.insertCarFromCarNames(new String[]{"A", "B", "C"});
        assertThat(raceController.carCount()).isEqualTo(3);
    }
}
