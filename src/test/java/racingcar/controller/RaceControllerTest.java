package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    RaceController raceController;

    @BeforeEach
    public void beforeEach() {
        raceController = new RaceController();
    }

    @Test
    public void 자동차_저장_확인() {
        raceController.insertCarFromCarNames(new String[]{"A", "B", "C"});
        assertThat(raceController.carCount()).isEqualTo(3);
    }

    @Test
    public void 우승자_확인() {
        raceController.insertCar(new Car("A", 1, () -> 1));
        raceController.insertCar(new Car("B", 3, () -> 1));
        raceController.insertCar(new Car("C", 4, () -> 1));
        assertThat(raceController.getWinners()).contains("C");
    }

    @Test
    public void 다중_우승자_확인() {
        raceController.insertCar(new Car("A", 1, () -> 1));
        raceController.insertCar(new Car("B", 1, () -> 1));
        raceController.insertCar(new Car("C", 1, () -> 1));
        assertThat(raceController.getWinners()).contains("A","B","C");
    }
}
