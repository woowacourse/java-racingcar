package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    private static final int PROCEED_FlAG_NUMBER = 4;

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("Car");
    }

    @Test
    void 전진_경우() {
        car.proceed(PROCEED_FlAG_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진_안하는_경우() {
        car.proceed(PROCEED_FlAG_NUMBER - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
