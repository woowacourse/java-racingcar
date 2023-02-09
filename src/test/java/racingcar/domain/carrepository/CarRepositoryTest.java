package racingcar.domain.carrepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRepositoryTest {

    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("두 개 이상이고 중복이 없는 자동차 객체의 배열이 입력되었을 때, CarRepository 객체가 생성되는지 확인")
    void validate_test(List<Car> cars) {
        CarRepository carRepository = new CarRepository(cars);

        assertThat(carRepository).isInstanceOf(CarRepository.class);
    }

    @ParameterizedTest
    @MethodSource("getWrongCars")
    @DisplayName("이름이 중복되거나 하나의 자동차만 입력되었을 때, 오류를 발생시키는지 확인")
    void validate_error_test(List<Car> cars) {
        assertThatThrownBy(() -> new CarRepository(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @MethodSource("getCarRepositoryAndRandomNumber")
    @DisplayName("자동차 이동 조건에 대한 서로 다른 숫자가 입력되었을 때, 자동차 이동 여부를 확인")
    void movePosition(List<Car> cars, int randomNumber, int expectedPosition) {
        CarRepository carRepository = new CarRepository(cars);

        carRepository.movePosition(randomNumber);

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }

    @Test
    void findWinner() {
    }

    static Stream<Arguments> getCars() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("poby"))),
                Arguments.arguments(List.of(new Car("poy"), new Car("oioy")))
        );
    }

    static Stream<Arguments> getWrongCars() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy"))),
                Arguments.arguments(List.of(new Car("poy"), new Car("poy")))
                );
    }

    static Stream<Arguments> getCarRepositoryAndRandomNumber() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 4, 1),
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 5, 1),
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 9, 1),
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 0, 0),
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 2, 0),
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("kane")), 3, 0)
                );
    }
}