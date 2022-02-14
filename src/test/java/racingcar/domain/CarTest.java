package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("Car");
    }

    @Test
    void 전진_경우() {
        car.proceed();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진_안하는_경우() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
