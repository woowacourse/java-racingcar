package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    @DisplayName("move 메서드는 값을 입력받고 4 이상인 경우 전진하고, 3 이하인 경우 멈춘다.")
    void should_move_when_valueIsMoreThanFour(final int value, final int position) {
        final Car car = new Car("Herb");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위치가 다르면 false를 반환한다.")
    void should_returnFalse_when_positionIsNotSame() {
        final Car car = new Car("Herb");
        car.move(Integer.MAX_VALUE);

        final boolean result = car.isSamePosition(new Car("Herb2"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위치가 같으면 true를 반환한다.")
    void should_returnSame_when_positionIsSame() {
        final Car car = new Car("Herb");

        final boolean result = car.isSamePosition(new Car("Herb2"));

        assertThat(result).isTrue();
    }
}
