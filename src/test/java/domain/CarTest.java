package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car("abc");

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("abc");
    }

    @Test
    void getResult() {
        assertThat(car.getResult()).isEqualTo("abc : \n");
    }

    @Test
    void move() {
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void getLocation() {
        assertThat(car.getLocation()).isEqualTo(0);
    }
}