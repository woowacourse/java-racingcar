package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {


    @Test
    @DisplayName("우승자 선정 기능 - 우승자가 1명일 경우 테스트")
    void getOneWinnersTest() {
        List<Car> cars = new ArrayList<>();
        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 1);
        Car test3 = new Car("test3", 1);
        Car test4 = new Car("test4", 1);
        Car test5 = new Car("test5", 2);
        cars.add(test1);
        cars.add(test2);
        cars.add(test3);
        cars.add(test4);
        cars.add(test5);
        RacingCars racingCars = new RacingCars(cars);

        Assertions.assertThat(racingCars.getWinners().size()).isEqualTo(1);
        Assertions.assertThat(racingCars.getWinners()).containsExactly(test1);
    }

    @Test
    @DisplayName("우승자 선정 기능 - 우승자가 복수일 경우 테스트")
    void getMultipleWinnersTest() {
        List<Car> cars = new ArrayList<>();
        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 3);
        Car test3 = new Car("test3", 3);
        Car test4 = new Car("test4", 1);
        Car test5 = new Car("test5", 2);
        cars.add(test1);
        cars.add(test2);
        cars.add(test3);
        cars.add(test4);
        cars.add(test5);
        RacingCars racingCars = new RacingCars(cars);

        Assertions.assertThat(racingCars.getWinners().size()).isEqualTo(3);
        Assertions.assertThat(racingCars.getWinners()).containsOnly(test1, test2, test3);
    }


    @Test
    @DisplayName("우승자 선정 기능 - 모두 동점일 경우 테스트")
    void getAllWinnersTest() {
        List<Car> cars = new ArrayList<>();
        Car test1 = new Car("test1", 1);
        Car test2 = new Car("test2", 1);
        Car test3 = new Car("test3", 1);
        Car test4 = new Car("test4", 1);
        Car test5 = new Car("test5", 1);
        cars.add(test1);
        cars.add(test2);
        cars.add(test3);
        cars.add(test4);
        cars.add(test5);
        RacingCars racingCars = new RacingCars(cars);

        Assertions.assertThat(racingCars.getWinners().size()).isEqualTo(5);
        Assertions.assertThat(racingCars.getWinners()).containsOnly(test1, test2, test3, test4, test5);
    }
}