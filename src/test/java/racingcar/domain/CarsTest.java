package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.DeterminedIntGenerator;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("전체 자동차를 이동 요청하면 각각의 자동차가 이동한다.")
    void shouldTryMoveEachCarWhenRequest() {
        // given
        List<String> names = List.of("phobi", "tele", "chan");
        Cars cars = new Cars(names, new DeterminedIntGenerator(4));
        // when
        cars.getCars()
                .forEach(car -> assertThat(car.getMovedCount()).isEqualTo(0));
        cars.requestMoveEachCar();
        // then
        cars.getCars()
                .forEach(car -> assertThat(car.getMovedCount()).isEqualTo(1));
    }

    @Test
    @DisplayName("2대의 자동차 중 1대의 자동차만 움직이면 해당 자동차 1대만 우승자가 된다.")
    void shouldReturnWinnerDataWhenRequest() {
        // given
        Car winnerCar = new Car("1th", new DeterminedIntGenerator(5));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        cars.requestMoveEachCar();
        List<Car> winners = cars.getWinner();
        // then
        assertThat(winners.get(0).getName()).isEqualTo("1th").as("우승자 이름과 같아야 한다.");
        assertThat(winners.size()).isEqualTo(1).as("우승자는 1명이어야 한다.");
    }

    @Test
    @DisplayName("3대의 자동차 중 2대의 자동차만 움직이면 해당 자동차 2대가 우승자가 된다.")
    void shouldReturnTwoWinnerDataWhenRequest() {
        // given
        Car winnerCar1 = new Car("1th-1", new DeterminedIntGenerator(5));
        Car winnerCar2 = new Car("1th-2", new DeterminedIntGenerator(6));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar1, winnerCar2, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        cars.requestMoveEachCar();
        List<Car> winners = cars.getWinner();
        // then
        assertThat(winners.size()).isEqualTo(2);
    }

}