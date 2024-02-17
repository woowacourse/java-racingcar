package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름이 정상적으로 생성되는가")
    void cars_generation_test() {
        List<String> carNames = List.of("mangc", "weve", "pobi", "neo");

        RacingCars racingCars = new RacingCars(carNames);
        List<Car> expected = List.of(new Car("mangc"), new Car("weve"), new Car("pobi"),
                new Car("neo"));

        assertThat(racingCars.getAllCars()).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("우승자가 정상적으로 반환되는가")
    void get_winners_test() {
        List<String> carNames = List.of("mangc", "weve", "pobi", "neo");
        RacingCars racingCars = new RacingCars(carNames);

        List<Car> cars = racingCars.getAllCars();
        Car winner = cars.get(0);
        winner.execute(9);

        assertThat(racingCars.getWinners()).containsExactly(winner);
    }
}
