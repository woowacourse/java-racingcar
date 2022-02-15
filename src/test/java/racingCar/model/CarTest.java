package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    public Car car = new Car("jiwoo");

    @Test
    void move_후_위치확인_잘되는지_검사() {
        car.move();
        assertThat(car.position.get()).isEqualTo(1);
    }

    @Test
    void 특정위치여부_확인_잘되는지_검사() {
        car.move();
        assertThat(car.position.isSame(1)).isTrue();
    }
}