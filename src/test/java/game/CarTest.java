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
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이동을_하는지_확인() {
        car.move(4);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
