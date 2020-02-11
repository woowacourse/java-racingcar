package Car;

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
}
