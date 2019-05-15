package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 생성자_null() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 생성자_5글자초과() {
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }


    @Test
    void move_포지션이1증가() {
        String name = "car";
        int position = 100;
        Car car = new Car(name, position);

        assertThat(car.move()).isEqualTo(new MovedCar(name, position + 1));
    }
}