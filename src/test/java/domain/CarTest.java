package domain;

import exception.CarNameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    Car car1;
    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
    }

    @Test
    @DisplayName("이동을 1번 했을 때 position은 1")
    void move() {
        car1.move(4);

        assertThat(car1.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 이름이 길면 예외를 던짐")
    void validateCarName() {
        assertThatThrownBy(() -> new Car("long_car_name")).isInstanceOf(CarNameLengthException.class);
    }
}