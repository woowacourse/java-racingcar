package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    void move_전진(int input) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getCurrentPosition()).isEqualTo("test : -");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void move_멈춤(int input) {
        Car car = new Car("test");
        car.move(input);
        assertThat(car.getCurrentPosition()).isEqualTo("test : ");
    }
}