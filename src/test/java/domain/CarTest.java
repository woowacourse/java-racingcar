package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"dazzle", ""})
    @DisplayName("생성자는 이름의 길이가 없거나 5보다 크다면 예외를 던진다.")
    void should_throwException_when_invalidNameLength(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상 ~ 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    @DisplayName("move 메서드는 값을 입력받고 4 이상인 경우 전진하고, 3 이하인 경우 멈춘다.")
    void should_move_when_valueIsMoreThanFour(int value, int position) {
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
