package domain;

import org.junit.jupiter.api.AfterEach;
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

    private MockNumberGenerator mockNumberGenerator
            = new MockNumberGenerator(MINIMUM_NUMBER_TO_MOVE, MINIMUM_NUMBER_TO_MOVE - 1, MINIMUM_NUMBER_TO_MOVE);


    @AfterEach
    void resetMockNumberGenerator() {
        mockNumberGenerator.resetIndex();
    }

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
     * 생성자를 통해 원하는 숫자를 순서대로 출력해주는 NumberGenerator
     */
    class MockNumberGenerator implements NumberGenerator {

        private final int[] values;
        private int index = 0;

        public MockNumberGenerator(int... value) {
            this.values = value;
        }

        @Override
        public int generate() {
            Integer value = values[index];
            index++;
            return value;
        }

        private void resetIndex() {
            index = 0;
        }
    }
}
