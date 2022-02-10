package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    RaceController raceController;

    @BeforeEach
    public void beforeEach() {
        raceController = new RaceController();
        raceController.insertCars(new String[]{"A","B","C"});
    }

    @Test
    public void 자동차_저장_확인() {
        assertThat(raceController.carCount()).isEqualTo(3);
    }
}
