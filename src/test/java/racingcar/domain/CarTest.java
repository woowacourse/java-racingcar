package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 생성 성공")
    @Test
    void createCar() {
        Car car = new Car("12345");
        assertThat(car.getName()).isEqualTo("12345");
    }

    @DisplayName("자동차 전진 O")
    @Test
    void moveForward1() {
        Car car = new Car("jae");
        car.moveForward(true);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @DisplayName("자동차 전진 X")
    @Test
    void moveForward2() {
        Car car = new Car("jae");
        car.moveForward(false);
        assertThat(car.getPosition()).isEqualTo(0);

    }
}
