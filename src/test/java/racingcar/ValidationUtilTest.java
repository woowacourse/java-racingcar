package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ValidationUtilTest {

    @Test
    @DisplayName("중복된 차 이름이 존재하는 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenHasDuplicateName() {
        List<Car> cars = List.of(new Car("one"), new Car("two"), new Car("one"));

        assertThatThrownBy(() -> Validator.checkDuplicateName(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가하는 자동차가 하나인 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenSinglePlayer() {
        List<Car> singleCar = List.of(new Car("one"));

        assertThatThrownBy(() -> Validator.checkSinglePlayer(singleCar))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("시도횟수가 0이하인 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCountLessThanOne() {
        assertThatThrownBy(() -> Validator.checkCountRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
