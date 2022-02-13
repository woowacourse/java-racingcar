package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void validateCarName_정상적인_이름() {
        assertThat(new Car("car1").getName()).isEqualTo("car1");
    }

    @Test
    void validateCarName_null() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_empty() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_다섯글자_초과() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void move_전진(int input) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void move_멈춤(int input) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}