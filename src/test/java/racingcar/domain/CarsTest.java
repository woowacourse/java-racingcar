package racingcar.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private static final int MAX_NUMBER_OF_POWER = 9;

    private static int uniqueIdentifier = 0;

    @DisplayName("중복된 자동차 이름이 있으면 예외를 던진다")
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

    @DisplayName("중복된 자동차 이름이 없으면 예외를 던지지 않는다")
    @ParameterizedTest
    @MethodSource("provideUniqueCarNames")
    void testValidNameLength(List<Car> cars) {
        assertDoesNotThrow(() -> new Cars(cars));
    }

    private static Stream<Arguments> provideUniqueCarNames() {
        return Stream.of(
                Arguments.of(createCarsWithName(List.of("조조네조", "감쟈감쟈", "연극끝"))),
                Arguments.of(createCarsWithName(List.of("수가성", "맛나요", "재방문각")))
        );
    }

    @DisplayName("이동한 거리가 같은 자동차 이름 리스트를 반환한다")
    @ParameterizedTest
    @MethodSource("provideCarsWithTargetDistanceAndCarName")
    void testFindCarNamesWithSameDistance(Cars cars, int distance, List<Integer> carNameIndexes) {
        List<String> carNames = cars.findCarNamesWithSameDistance(distance);
        List<Car> carList = cars.values();
        assertThat(
                carNameIndexes.stream()
                .map(index -> carList.get(index).getName())
                .toList()
        ).containsAll(carNames);
    }

    private static Stream<Arguments> provideCarsWithTargetDistanceAndCarName() {
        return Stream.of(
                Arguments.of(createCarsWithDistance(List.of(10, 3, 5, 20, 3, 6)), 6, List.of(5)),
                Arguments.of(createCarsWithDistance(List.of(101, 20, 50, 101, 100)), 101, List.of(0, 3)),
                Arguments.of(createCarsWithDistance(List.of(1, 1, 1, 1, 1)), 1, List.of(0, 1, 2, 3, 4)),
                Arguments.of(createCarsWithDistance(List.of(1, 1, 1, 1, 1)), 0, List.of())
        );
    }

    @DisplayName("가장 멀리 이동한 거리를 반환한다")
    @ParameterizedTest
    @MethodSource("provideCarsWithMaxDistance")
    void testFindMaxDistance(Cars cars, int maxDistance) {
        assertThat(cars.findMaxDistance())
                .isEqualTo(maxDistance);
    }

    private static Stream<Arguments> provideCarsWithMaxDistance() {
        return Stream.of(
                Arguments.of(createCarsWithDistance(List.of(0, 1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(createCarsWithDistance(List.of(10, 20, 50, 101, 100)), 101),
                Arguments.of(createCarsWithDistance(List.of(1, 1, 1, 1, 1, 1)), 1)
        );
    }

    private static Cars createCarsWithDistance(List<Integer> distances) {
        return distances.stream()
                .map(CarsTest::createCarWithDistance)
                .collect(collectingAndThen(toList(), Cars::new));
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
