package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {

    @Test
    public void 자동차_저장_확인() {
        RaceController raceController = new RaceController();
        raceController.insertCars(new String[]{"A","B","C"});
        assertThat(raceController.carCount()).isEqualTo(3);
    }
}
