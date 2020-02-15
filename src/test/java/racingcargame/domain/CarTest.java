package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 자동차는_이름을_입력받아_생성() {
        String name = "재주";
        Car car = new Car(name);
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_이름은_비어있는_문자열이면_예외발생() {
        String name = "";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_null이면_예외발생() {
        String name = null;
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_5자이내여야_한다() {
        String name = "notfive!!";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_4이상의숫자를받으면_전진한다() {
        String name = "장재주";
        Car car = new Car(name);
        car.move(4);
        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    void 자동차는_3이하일경우_전진하지않는다() {
        String name = "장재주";
        Car car = new Car(name);
        car.move(3);
        assertThat(car.isSamePosition(0)).isTrue();
    }
}
