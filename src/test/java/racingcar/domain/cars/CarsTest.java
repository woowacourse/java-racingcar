package racingcar.domain.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("두 개 이상이고 중복이 없는 자동차 객체의 배열이 입력되었을 때, CarRepository 객체가 생성되는지 확인")
    void validate_test(List<Car> cars) {
        Cars carRepository = new Cars(cars);

        assertThat(carRepository).isInstanceOf(Cars.class);
    }

    @ParameterizedTest
    @MethodSource("getWrongCars")
    @DisplayName("이름이 중복되거나 하나의 자동차만 입력되었을 때, 오류를 발생시키는지 확인")
    void validate_error_test(List<Car> cars) {
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @MethodSource("getCars")
    void findWinner(List<Car> cars) {
        Car movedCar = createMovedCar();
        cars.add(movedCar);
        Cars carRepository = new Cars(cars);

        List<String> winners = carRepository.findWinner();

        assertThat(winners).containsAnyOf(movedCar.getName());
    }

    static Stream<Arguments> getCars() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of(new Car("poy"), new Car("joy"), new Car("poby")))),
                Arguments.arguments(new ArrayList<>(List.of(new Car("poy"), new Car("oioy"))))
        );
    }

    private Car createMovedCar() {
        Car winner = new Car("win");
        winner.updatePosition();
        return winner;
    }

    static Stream<Arguments> getWrongCars() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy"))),
                Arguments.arguments(List.of(new Car("poy"), new Car("poy")))
        );
    }
}