package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Car.DEFAULT_POSITION_VALUE;
import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("moveCars를 통해 조건을 충족시킨 Car를 move 시킨다.")
    @Test
    void moveCars() {
        Cars cars = createCars(3);
        int[] moveOrder = {MINIMUM_NUMBER_TO_MOVE, MINIMUM_NUMBER_TO_MOVE - 1, MINIMUM_NUMBER_TO_MOVE};
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(moveOrder);

        cars.move(mockNumberGenerator);

        List<Integer> positions = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions)
                .containsExactly(DEFAULT_POSITION_VALUE + 1, DEFAULT_POSITION_VALUE, DEFAULT_POSITION_VALUE + 1);
    }

    @DisplayName("findWinners()를 통해 position이 가장 높은 Car들을 가져온다")
    @Test
    void findWinners() {
        Cars cars = createCars(3);
        int[] moveOrder = {MINIMUM_NUMBER_TO_MOVE, MINIMUM_NUMBER_TO_MOVE - 1, MINIMUM_NUMBER_TO_MOVE};
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(moveOrder);

        cars.move(mockNumberGenerator);
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(cars.getCars().get(0), cars.getCars().get(2));
    }

    private Cars createCars(int size) {
        List<Car> carsInput = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carsInput.add(new Car(new Name("car" + i)));
        }
        return new Cars(carsInput);
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
            int value = values[index];
            index++;
            return value;
        }
    }
}
