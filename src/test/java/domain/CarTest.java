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
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("123456");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("");
        });

        assertThat(car.getName()).isEqualTo("hello");
    }

    @Test
    void increase_자동차_포지션_증가일_경우() {
        int init = car.getPosition();
        for (int i = Const.GO_RAN_NUM; i < Const.RANGE_RAN_NUM; i++) {
            car.increasePositionOrNot(i);
            assertThat(car.getPosition()).isEqualTo(++init);
        }

    }

    @Test
    void increase_자동차_포지션_변화_없음() {
        int init = car.getPosition();
        for (int i = Const.ZERO; i < Const.GO_RAN_NUM; i++) {
            car.increasePositionOrNot(i);
            assertThat(car.getPosition()).isEqualTo(init);
        }
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}