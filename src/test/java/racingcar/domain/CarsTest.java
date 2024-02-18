package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private static final int MAX_NUMBER_OF_POWER = 9;

    private static int uniqueIdentifier = 0;

    @DisplayName("중복된 자동차 이름이 존재하면 예외를 던진다")
    @ParameterizedTest
    @MethodSource("provideDuplicatedCarNames")
    void testUniqueCarNames(List<Car> cars) {
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideDuplicatedCarNames() {
        return Stream.of(
                Arguments.of(createCarsWithName(List.of("조조네조", "감쟈감쟈", "조조네조"))),
                Arguments.of(createCarsWithName(List.of("123", "123", "1 2 3")))
        );
    }

    private static List<Car> createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    @DisplayName("가장 멀리 이동한 거리를 반환한다")
    @ParameterizedTest
    @MethodSource("provideCarsWithMaxDistance")
    void testFindMaxDistance(List<Car> cars, int maxDistance) {
        assertThat(new Cars(cars).findMaxDistance())
                .isEqualTo(maxDistance);
    }

    private static Stream<Arguments> provideCarsWithMaxDistance() {
        return Stream.of(
                Arguments.of(createCarsWithDistance(List.of(0, 1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(createCarsWithDistance(List.of(10, 20, 50, 101, 100)), 101),
                Arguments.of(createCarsWithDistance(List.of(1, 1, 1, 1, 1, 1)), 1)
        );
    }

    private static List<Car> createCarsWithDistance(List<Integer> distances) {
        return distances.stream()
                .map(CarsTest::createCarWithDistance)
                .toList();
    }

    private static Car createCarWithDistance(int distance) {
        Car car = new Car(String.valueOf(uniqueIdentifier++));
        while (distance > 0) {
            car.goIfNumberOfPowerEnough(MAX_NUMBER_OF_POWER);
            distance--;
        }
        return car;
    }
}
