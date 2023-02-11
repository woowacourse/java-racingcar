package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {


    @Test
    @DisplayName("우승자 선정 기능 - 우승자가 1명일 경우 테스트")
    void getOneWinnersTest() {
        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 1);
        Car test3 = new Car("test3", 1);
        Car test4 = new Car("test4", 1);
        Car test5 = new Car("test5", 2);
        RacingCars racingCars = new RacingCars(List.of(test1, test2, test3, test4, test5));

        Assertions.assertThat(racingCars.getWinners().size()).isEqualTo(1);
        Assertions.assertThat(racingCars.getWinners()).containsExactly(test1);
    }

    @Test
    @DisplayName("우승자 선정 기능 - 우승자가 복수일 경우 테스트")
    void getMultipleWinnersTest() {
        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 3);
        Car test3 = new Car("test3", 3);
        Car test4 = new Car("test4", 1);
        Car test5 = new Car("test5", 2);
        RacingCars racingCars = new RacingCars(List.of(test1, test2, test3, test4, test5));

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
        RacingCars racingCars = new RacingCars(List.of(test1, test2, test3, test4, test5));

        Assertions.assertThat(racingCars.getWinners().size()).isEqualTo(5);
        Assertions.assertThat(racingCars.getWinners()).containsOnly(test1, test2, test3, test4, test5);
    }
}
