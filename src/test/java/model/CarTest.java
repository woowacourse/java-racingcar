package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("숫자가 4 이상인 경우 전진한다.")
    void move() {
        Car car = new Car("배키");
        car.move(4);

        String result = car.generateMovement();
        String expected = "-";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 3 이하인 경우 전진하지 않는다.")
    void notMove() {
        Car car = new Car("명오");
        car.move(3);

        String result = car.generateMovement();
        String expected = "";

        assertThat(result).isEqualTo(expected);
    }
}