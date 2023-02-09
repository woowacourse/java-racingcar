package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("findWinners()를 통해 position이 가장 높은 Car들을 가져온다")
    @Test
    void test1() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carA.move(MINIMUM_NUMBER_TO_MOVE);
        carB.move(MINIMUM_NUMBER_TO_MOVE);

        Cars cars = new Cars(List.of(carA, carB, carC));
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(carA, carB);
    }
}