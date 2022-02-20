package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("이름이 5글자를 넘을 때 Exception 발생")
    public void name_longer_then_5_exception() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 공백일 때 Exception 발생")
    public void name_blank_exception() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("true일 때 차 이동")
    public void move_true() {
        Car car = new Car("forky");
        car.move(true);
        assertThat(car.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("false일 때 차 이동")
    public void move_false() {
        Car car = new Car("forky");
        car.move(false);
        assertThat(car.getPosition())
                .isEqualTo(0);
    }
}
