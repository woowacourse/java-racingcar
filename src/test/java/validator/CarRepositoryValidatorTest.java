package validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.List;

public class CarRepositoryValidatorTest {
    @Test
    @DisplayName("입력한 차가 한 대 이상이며 이름이 중복되지 않은 경우 정상적으로 실행한다.")
    void addToCarRepository() {
        List<Car> cars = List.of(new Car("aa"), new Car("bb"), new Car("cc"));
        Assertions.assertThatNoException()
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
}
