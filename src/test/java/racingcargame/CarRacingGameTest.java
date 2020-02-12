package racingcargame;

import racingcargame.domain.Car;
import racingcargame.domain.RacingCarGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    ArrayList<Car> cars = new ArrayList<>();
    RacingCarGame racingCarGame = new RacingCarGame();

    @ParameterizedTest
    @DisplayName("자동차가 4,5,6,7,8,9일 때 전진하는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int random) {
        Car car = new Car("car");
        int originalPosition = car.getCarPosition();
        car.decideGoOrStop(random);
        assertThat(car.getCarPosition()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 0,1,2,3일 때 멈춰있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int random) {
        Car car = new Car("car");
        int originalPosition = car.getCarPosition();
        car.decideGoOrStop(random);
        assertThat(car.getCarPosition()).isEqualTo(originalPosition);
    }

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
        assertThat(racingCarGame.getWinner(cars)).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 복수일 때 이름이 제대로 추출되는지")
    void checkWinnersName() {
        cars.get(0).decideGoOrStop(8);
        cars.get(1).decideGoOrStop(5);
        cars.get(2).decideGoOrStop(0);
        assertThat(racingCarGame.getWinner(cars)).isEqualTo("car1, car2");
    }
}
