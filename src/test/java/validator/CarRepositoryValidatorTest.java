package validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Car;

import java.util.List;
import java.util.stream.Stream;

public class CarRepositoryValidatorTest {
    @ParameterizedTest
    @MethodSource("provideCars")
    @DisplayName("입력한 차가 두 대 이상, 열 대 이하이며 이름이 중복되지 않은 경우 정상적으로 실행한다.")
    void addToCarRepository(List<Car> cars) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarRepositoryValidator.validate(cars));
    }

    @Test
    @DisplayName("중복되는 차 이름이 있을 때 예외를 발생시킨다.")
    void validateDuplicatedCarNames() {
        List<Car> cars = List.of(new Car("aa"), new Car("aa"));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarRepositoryValidator.validate(cars));
    }

    @Test
    @DisplayName("입력한 차가 한 대인 경우 예외를 발생시킨다.")
    void validateLessThanMinimumNumberOfCars() {
        List<Car> cars = List.of(new Car("aa"));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarRepositoryValidator.validate(cars));
    }

    @Test
    @DisplayName("입력한 차가 열 대 이상인 경우 예외를 발생시킨다.")
    void validateMoreThanMaximumNumberOfCars() {
        List<Car> cars = List.of(
                new Car("aa"), new Car("aa"), new Car("aa"),
                new Car("aa"),new Car("aa"), new Car("aa"),
                new Car("aa"), new Car("aa"), new Car("aa"),
                new Car("aa"));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarRepositoryValidator.validate(cars));
    }

    private static Stream<Arguments> provideCars() {
        return Stream.of(
                Arguments.of(List.of(new Car("aa"), new Car("bb")),
                Arguments.of(List.of(new Car("aa"), new Car("bb"), new Car("cc"))),
                Arguments.of(List.of(new Car("aa"), new Car("bb"), new Car("cc")), new Car("aa"), new Car("bb"), new Car("cc"))),
                Arguments.of(List.of(
                        new Car("aa"), new Car("bb"), new Car("cc"), new Car("aa"),
                        new Car("bb"), new Car("cc"), new Car("bb"), new Car("cc"),
                        new Car("bb"), new Car("cc")
                ))
        );
    }

}
