package racingcar.domain.carrepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

import java.util.ArrayList;
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

    @Test
    @DisplayName("자동차 이름이 중복되었을 때, 오류를 발생시키는지 확인")
    void validate_error_test_about_name_duplication() {
        List<Car> wrongCars = List.of(new Car("poy"), new Car("poy"));

        assertThatThrownBy(() -> new CarRepository(wrongCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("하나의 자동차 이름만 입력되었을 때, 오류가 발생하는지 확인")
    void validate_error_test_about_number_of_cars_limit() {
        List<Car> wrongCar = List.of(new Car("poy"));

        assertThatThrownBy(() -> new CarRepository(wrongCar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("getCars")
    void findWinner(List<Car> cars) {
        Car movedCar = createMovedCar();
        cars.add(movedCar);
        CarRepository carRepository = new CarRepository(cars);

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
        winner.move();
        return winner;
    }
}