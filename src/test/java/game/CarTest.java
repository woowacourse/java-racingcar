package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("bongjin");
    }

    @Test
    void 자동차_이름_확인() {
        String result = car.getName();
        assertThat(result).isEqualTo("bongjin");
    }

    @Test
    void 이동을_하지않는지_확인() {
        boolean result = car.isMaxInstance(1);
        car.move(3);
        assertThat(result).isFalse();
    }

    @Test
    void 최대_이동_거리_미달_확인() {
        boolean result = car.isMaxInstance(5);
        car.move(4);
        assertThat(result).isFalse();
    }

    @Test
    void 최대_이동_거리_도달_확인() {
        car.move(4);
        car.move(4);
        car.move(4);
        boolean result = car.isMaxInstance(3);
        assertThat(result).isTrue();
    }
}
