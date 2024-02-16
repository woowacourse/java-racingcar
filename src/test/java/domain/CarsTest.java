package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @DisplayName("가장 멀리간 차가 우승자가 된다.")
    @Test
    void findSingleWinnerTest() {
        MockCar carA = new MockCar(1);
        MockCar carB = new MockCar(2);
        List<Car> carList = List.of(carA, carB);
        Cars cars = new Cars(carList, () -> true);

        List<Car> winners = cars.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(carB);
    }

    @DisplayName("우승자가 여려명이 될 수 있다.")
    @Test
    void findMultipleWinnerTest() {
        MockCar carA = new MockCar(2);
        MockCar carB = new MockCar(2);
        MockCar carC = new MockCar(1);
        List<Car> carList = List.of(carA, carB, carC);
        Cars cars = new Cars(carList, () -> true);

        List<Car> winners = cars.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(carA, carB);
    }

    @DisplayName("전략에 따라 전진 유무가 결정된다.")
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void moveTest(boolean isMove, int expectedPosition) {
        MockCar carA = new MockCar();
        List<Car> carList = List.of(carA);
        Cars cars = new Cars(carList, () -> isMove);

        cars.move();

        Assertions.assertThat(carA.getPosition()).isEqualTo(expectedPosition);
    }
}
