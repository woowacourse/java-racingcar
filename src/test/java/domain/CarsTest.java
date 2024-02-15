package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @DisplayName("임의의 숫자가 3 이하인 경우에는 이동하지 않고, 4 이상인 경우에는 이동한다")
    @ParameterizedTest
    @CsvSource({"3, 0", "4, 1"})
    void moveRandomlyTest(int randomInt, int expectedPosition) {
        Cars cars = new Cars(List.of(new MockCar()), () -> randomInt);

        cars.moveRandomly();

        int actualPosition = cars.getCarList().get(0).getPosition();
        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("가장 멀리간 차가 우승자가 된다.")
    @Test
    void findSingleWinnerTest() {
        MockCar carA = new MockCar(1);
        MockCar carB = new MockCar(2);
        List<Car> carList = List.of(carA, carB);
        Cars cars = new Cars(carList, () -> 0);

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
        Cars cars = new Cars(carList, () -> 0);

        List<Car> winners = cars.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(carA, carB);
    }

}