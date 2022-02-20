package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.exception.InvalidCarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("인자로 전달받은 숫자가 4 이상일 경우 전진한다")
    void shouldMoveWhenGetsFour() {
        // given
        Car car = new Car("test");
        int beforeMove = car.getPosition();
        int number = 4;
        // when
        car.move(number);

        // then
        assertThat(beforeMove).isEqualTo(1);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 position인 경우 참을 반환한다")
    void shouldReturnTrueWhenSamePosition() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        //when

        //then
        assertThat(car1.isSamePositionWith(car2)).isTrue();
    }

    @Test
    @DisplayName("같은 position이 아닌 경우 거짓을 반환한다")
    void shouldReturnFalseWhenDifferentPosition() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        //when
        car1.move(4);
        //then
        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }

    @Test
    @DisplayName("자동차의 이름 길이가 5를 초과할 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCarNameLengthOverFive() {
        assertThatThrownBy(() -> new Car("longCarName"))
                .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    @DisplayName("자동차의 이름 길이가 1보다 작은 경우 예외를 발생시킨다")
    void shouldThrowExceptionWhenCarNameLengthLessThanOne() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(InvalidCarNameException.class);
    }
}
