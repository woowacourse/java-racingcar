package racingcar.domain.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarsTest {

    private static final int ENOUGH_POWER_TO_MOVE = 4;
    private static final int INSUFFICIENT_POWER_TO_MOVE = 3;
    private static final int DEFAULT_POSITION = 0;

    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("생성자에 길이가 2 이상이고 중복이 없는 자동차 객체 배열이 입력되었을 때, 오류가 발생하지 않는지 확인")
    void create_test(final List<Car> cars) {
        assertDoesNotThrow(() -> new Cars(cars));
    }

    @ParameterizedTest
    @MethodSource("getWrongCars")
    @DisplayName("생성자에 이름이 중복되거나 길이가 2 미만인 자동차 객체 배열이 입력되었을 때, 오류를 발생시키는지 확인")
    void create_error_test(final List<Car> cars) {
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("moveBy 메소드에 자동차가 움직일만한 power가 입력되었을 때, 자동차들이 이동하는지 확인")
    void moveBy_moving_test(final List<Car> exampleCars) {
        Cars cars = new Cars(exampleCars);
        List<Integer> unmovedPositions = getPositionOfCars(cars);

        cars.moveBy(() -> ENOUGH_POWER_TO_MOVE);
        List<Integer> movedPositions = getPositionOfCars(cars);

        assertThat(movedPositions).isNotEqualTo(unmovedPositions);
    }

    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("moveBy 메소드에 자동차가 움직이지 못할 power가 입력되었을 때, 자동차들이 멈춰있는지 확인")
    void moveBy_stopping_test(final List<Car> exampleCars) {
        Cars cars = new Cars(exampleCars);
        List<Integer> unmovedPositions = getPositionOfCars(cars);

        cars.moveBy(() -> INSUFFICIENT_POWER_TO_MOVE);
        List<Integer> movedPositions = getPositionOfCars(cars);

        assertThat(movedPositions).isEqualTo(unmovedPositions);
    }

    private List<Integer> getPositionOfCars(final Cars cars) {
        return cars.getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    static Stream<Arguments> getCars() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", DEFAULT_POSITION), new Car("poby", DEFAULT_POSITION)))),
                Arguments.arguments(new ArrayList<>(List.of(new Car("poy", DEFAULT_POSITION), new Car("oioy", DEFAULT_POSITION))))
        );
    }

    static Stream<Arguments> getWrongCars() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy", DEFAULT_POSITION))),
                Arguments.arguments(List.of(new Car("poy", DEFAULT_POSITION), new Car("poy", DEFAULT_POSITION)))
        );
    }
}
