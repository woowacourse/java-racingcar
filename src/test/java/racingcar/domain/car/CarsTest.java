package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.generator.RandomOilGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private static final int MOVABLE_OIL_AMOUNT = 9;

    @DisplayName("우승자의 이름을 올바르게 반환한다")
    @ParameterizedTest
    @MethodSource("provideCarsWithWinnersName")
    void testGetWinnersName(Cars cars, List<String> expectedWinnersName) {
        List<String> winnersName = cars.getWinnersName();

        assertThat(winnersName.size()).isEqualTo(expectedWinnersName.size());
        for (String winnerName : winnersName) {
            assertTrue(expectedWinnersName.contains(winnerName));
        }
    }

    private static Stream<Arguments> provideCarsWithWinnersName() {
        return Stream.of(
                Arguments.of(createCarsWithDistance(List.of(0, 1, 2, 3, 4, 5, 6)), List.of("6")),
                Arguments.of(createCarsWithDistance(List.of(10, 20, 50, 101, 100)), List.of("3")),
                Arguments.of(createCarsWithDistance(List.of(1, 1, 1, 1, 1, 1)), List.of("0", "1", "2", "3", "4", "5"))
        );
    }

    private static Cars createCarsWithDistance(List<Integer> distances) {
        List<Car> cars = new ArrayList<>();
        for (int count = 0; count < distances.size(); count++) {
            int distance = distances.get(count);
            Car car = createCarWithDistance(distance, String.valueOf(count));
            cars.add(car);
        }

        return new Cars(cars, new RandomOilGenerator());
    }

    private static Car createCarWithDistance(int distance, String name) {
        Car car = new Car(name);
        while (distance > 0) {
            distance--;
            car.goIfOilEnough(MOVABLE_OIL_AMOUNT);
        }

        return car;
    }
}
