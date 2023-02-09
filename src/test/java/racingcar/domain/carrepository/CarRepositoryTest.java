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

class CarRepositoryTest {

    @ParameterizedTest
    @MethodSource("getCarRepository")
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

    static Stream<Arguments> getCarRepository() {
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