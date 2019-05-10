package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 객체_생성() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void 다섯_글자_이상_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("ppoobbii");
        });
    }

    @Test
    void 전진() {
        Car car = new Car("pobi", 0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 더_먼_위치() {
        Car car = new Car("pobi", 4);
        assertThat(car.isFartherPosition(3)).isTrue();
    }

    @Test
    void 같은_위치() {
        Car car = new Car("pobi", 4);
        assertThat(car.isSamePosition(4)).isTrue();
    }


}
