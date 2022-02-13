package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int PROCEED_FlAG_NUMBER = 4;

    @Test
    @DisplayName("전진 여부 - 전진O")
    void proceed_O() {
        Car car = new Car("Car");
        car.proceed(PROCEED_FlAG_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 여부 - 전진X")
    void proceed_X() {
        Car car = new Car("Car");
        car.proceed(PROCEED_FlAG_NUMBER - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
