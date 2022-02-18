package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars = Cars.getInstance();

    @BeforeEach
    public void beforeEach() {
        String[] defaultCarNames = {};
        cars.removeAll();
    }

    @Test
    public void 자동차_저장_확인() {
        cars.insertCarFromCarNames(new String[]{"A", "B", "C"});
        assertThat(cars.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("서로 다른 위치를 가진 우승자들 사이에서 1명의 우승자가 등장")
    public void 우승자_확인() {
        Car winner = new Car("A", () -> 5);
        Car loser1 = new Car("B", () -> 5);
        Car loser2 = new Car("C", () -> 5);
        setPosition(winner, 1);
        cars.insertCar(winner);
        cars.insertCar(loser1);
        cars.insertCar(loser2);
        assertThat(cars.getWinners()).contains("A");
    }

    @Test
    @DisplayName("2명의 우승자가 존재하는 경우")
    public void 다중_우승자_확인() {
        Car winner1 = new Car("A", () -> 5);
        Car winner2 = new Car("B", () -> 5);
        Car loser = new Car("C", () -> 5);
        setPosition(winner1, 5);
        setPosition(winner2, 5);
        cars.insertCar(winner1);
        cars.insertCar(winner2);
        cars.insertCar(loser);
        assertThat(cars.getWinners()).contains("A","B");
    }

    private void setPosition(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.move();
        }
    }
}
