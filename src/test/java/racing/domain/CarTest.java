package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름의 길이가 1보다 작거나 5보다 큰 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void throwExceptionWhenLengthOfCarNameOutOfRange(String input) {
        assertThatThrownBy(() ->  new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이가 1이상 5이하이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createCarWhenLengthOfCarNameIsValidate(String input) {
        assertDoesNotThrow(() -> new Car(input));
    }

    @DisplayName("자동차의 move메소드는 전진하는 경우 위치가 1만큼 증가한다.")
    @Test
    void moveWhenRandomNumberIsOverThree() {
        //given
        Car car = new Car("123");
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        //when
        car.move(numberGenerator);
        System.out.println(car.getPosition().getPosition());

        //then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("자동차의 move메소드는 전전하지 않는 경우 위치가 유지된다.")
    @Test
    void moveWhenRandomNumberIsUnderThree() {
        //given
        Car car = new Car("123");
        NumberGenerator numberGenerator = new NonMovableNumberGenerator();

        //when
        car.move(numberGenerator);

        //then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}