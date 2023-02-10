package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private final NumberGenerator mockNumberGenerator = new MockNumberGenerator(List.of(5, 3, 5));

    @DisplayName("moveCars를 통해 조건을 충족시킨 Car를 move 시킨다.")
    @Test
    void moveCars() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Cars cars = new Cars(List.of(carA, carB, carC));

        cars.moveCars(mockNumberGenerator);
        List<Car> afterCarMoved = cars.getCars();

        List<Integer> expected = afterCarMoved.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        assertThat(expected).isEqualTo(List.of(1, 0, 1));
    }

    @DisplayName("findWinners()를 통해 position이 가장 높은 Car들을 가져온다")
    @Test
    void findWinners() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Cars cars = new Cars(List.of(carA, carB, carC));

        cars.moveCars(mockNumberGenerator);
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(carA, carC);
    }

    class MockNumberGenerator implements NumberGenerator {
        private final List<Integer> values;
        private int index = 0;

        public MockNumberGenerator(List<Integer> values){
            this.values = values;
        }

        @Override
        public int generate() {
            return values.get(index++);
        }
    }
}
