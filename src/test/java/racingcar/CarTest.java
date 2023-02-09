package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("Mery");
    }

    @Test
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"merrrrrrry", "pooooooobi", "pooooo", ""})
    void makeCars(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }
}