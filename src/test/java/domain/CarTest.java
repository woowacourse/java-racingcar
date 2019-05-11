package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hello");
    }

    @Test
    void create_자동차_객체_생성() {
        assertThat(car.getName()).isEqualTo("hello");
    }

    @Test
    void create_자동차_이름_5자이상_예외_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("123456");
        });
    }

    @Test
    void create_자동차_이름_빈값_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("");
        });
    }

    @Test
    void increase_자동차_포지션_증가일_경우() {
        int init = car.getPosition();
        car.increasePositionOrNot(4);
        assertThat(car.getPosition()).isEqualTo(++init);

    }

    @Test
    void increase_자동차_포지션_변화_없음() {
        int init = car.getPosition();
        car.increasePositionOrNot(3);
        assertThat(car.getPosition()).isEqualTo(init);
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}