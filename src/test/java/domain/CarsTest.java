package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.NumberGenerator;

import java.util.List;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private final NumberGenerator mockNumberGenerator = new MockNumberGenerator();

    @DisplayName("moveCars를 통해 조건을 충족시킨 Car를 move 시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:1"}, delimiter = ':')
    void test1(int index, int expectedPosition) {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Cars cars = new Cars(List.of(carA, carB, carC));

        cars.moveCars(mockNumberGenerator);

        Car carAfterMove = cars.getCars().get(index);
        assertEquals(carAfterMove.getPosition(), expectedPosition);
    }

    @DisplayName("findWinners()를 통해 position이 가장 높은 Car들을 가져온다")
    @Test
    void test2() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Cars cars = new Cars(List.of(carA, carB, carC));

        cars.moveCars(mockNumberGenerator);
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(carA, carC);
    }

    /**
     * 홀수번은 move가 가능한 숫자를, 짝수번에는 move가 불가능한 숫자를 반환하는 NumberGenerator
     */
    class MockNumberGenerator implements NumberGenerator {

        private List<Integer> values = List.of(MINIMUM_NUMBER_TO_MOVE , MINIMUM_NUMBER_TO_MOVE-1);
        private int index = 0;

        @Override
        public int generate() {
            Integer value = values.get(index);

            if (index == 0) {
                index++;
                return value;
            }

            index--;
            return value;
        }
    }
}
