package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.domain.Car;
import racingcargame.domain.RacingCars;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    ArrayList<Car> cars = new ArrayList<>();
    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

    @Test
    @DisplayName("우승자의 이름이 제대로 추출되는지")
    void checkWinnerName() {
        cars.get(0).decideGoOrStop(8);
        cars.get(1).decideGoOrStop(1);
        cars.get(2).decideGoOrStop(0);
        assertThat(racingCars.getWinner()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 복수일 때 이름이 제대로 추출되는지")
    void checkWinnersName() {
        cars.get(0).decideGoOrStop(8);
        cars.get(1).decideGoOrStop(5);
        cars.get(2).decideGoOrStop(0);
        assertThat(racingCars.getWinner()).isEqualTo("car1, car2");
    }
}
