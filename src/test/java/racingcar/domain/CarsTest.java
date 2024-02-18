package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    @Test
    @DisplayName("[Success] 자동차가 정상적으로 생성됨")
    void createCars() {
        List<Car> cars = List.of(
                Car.from("a"),
                Car.from("b")
        );

        assertThatCode(() -> new Cars(cars))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[Exception] 중복된 자동차 이름이 있으면 예외를 던진다")
    void createCarsByDuplicateCarNames() {
        List<Car> cars = List.of(
                Car.from("123"),
                Car.from("123")
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(cars))
                .withMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("InputCarNames")
    @DisplayName("[Exception] 자동차 대수가 2대 미만이거나 10대 초과하면 예외를 던진다")
    void createCarsByInvalidSize(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(cars))
                .withMessage("자동차 대수는 2대 이상 10대 이하여야 합니다.");
    }

    private static Stream<Arguments> InputCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("1")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
        );
    }

    @Test
    @DisplayName("[Success] 자동차 전진 횟수가 가장 많은 차들의 이름을 반환한다")
    void getWinners() {
        Car car1 = Car.from("car1");
        car1.move(4);
        car1.move(4);
        Car car2 = Car.from("car2");
        car2.move(4);
        car2.move(4);
        Car car3 = Car.from("car3");
        car3.move(1);
        car3.move(1);

        Cars cars = new Cars(List.of(car1, car2, car3));

        Assertions.assertThat(cars.getWinners())
                .isEqualTo(List.of("car1", "car2"));
    }
}
