package domain;

import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void createCar_적합한_이름() {
        new Car("타미");
    }

    @Test
    void createCar_부적합한_이름길이() {
        assertThatThrownBy(() ->  new Car("우아한형제들"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
