package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 생성자_이름_빈_문자() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성자_이름_공백() {
        assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성자_이름_5글자초과() {
        assertThatThrownBy(() -> new Car("kimchan"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성자_초기_자동차_위치() {
        Car car = new Car("chan");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("chan");
        car.forward(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_위치_비교() {
        Car car = new Car("chan");
        car.forward(true);
        assertThat(car.isSamePositionWith(1)).isEqualTo(true);
    }
}
