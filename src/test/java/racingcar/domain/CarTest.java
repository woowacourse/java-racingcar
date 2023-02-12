package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest(name = "move 메서드는 값을 입력받고 4이상인 경우 전진한다. 초기 위치: 0 입력값: {0} 동작 후 위치: {1}")
    @CsvSource(value = {"4,1", "3,0"})
    void should_move_when_valueIsMoreThanFour(final int value, final int position) {
        Car car = new Car("Herb");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위치가 다르면 false를 반환한다.")
    void should_returnFalse_when_positionIsNotSame() {
        Car car = new Car("Herb");
        car.move(Integer.MAX_VALUE);

        boolean result = car.isSamePosition(new Car("Herb2"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위치가 같으면 true를 반환한다.")
    void should_returnSame_when_positionIsSame() {
        Car car = new Car("Herb");

        boolean result = car.isSamePosition(new Car("Herb2"));

        assertThat(result).isTrue();
    }
}
