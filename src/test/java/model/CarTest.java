package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("숫자가 4 이상인 경우 전진한다.")
    @Test
    void move() {
        Car car = new Car("배키", () -> 4);
        car.move();

        String result = car.generateMovement();
        String expected = "-";

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자가 3 이하인 경우 전진하지 않는다.")
    @Test
    void notMove() {
        Car car = new Car("명오", () -> 3);
        car.move();

        String result = car.generateMovement();
        String expected = "";

        assertThat(result).isEqualTo(expected);
    }
}