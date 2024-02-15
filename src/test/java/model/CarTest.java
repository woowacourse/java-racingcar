package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("true면 전진한다.")
    void move() {
        Car car = new Car("배키");
        car.move(true);

        String result = car.generateMovement();
        String expected = "-";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("false면 전진하지 않는다.")
    void notMove() {
        Car car = new Car("명오");
        car.move(false);

        String result = car.generateMovement();
        String expected = "";

        assertThat(result).isEqualTo(expected);
    }
}