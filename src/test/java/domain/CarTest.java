package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;
    String carInitName;

    @BeforeEach
    void setUp() {
        carInitName = "hello";
        car = new Car(carInitName);
    }

    @Test
    void create_자동차_객체_생성() {
        assertThat(car).isEqualTo(new Car(carInitName));
    }

    @Test
    void create_자동차_객체_생성_포지션_확인() {
        assertThat(car).isEqualTo(new Car(carInitName,Const.CAR_OBJ_INIT_POSITION));
    }

    @Test
    void create_자동차_객체_생성_포지션() {
        int position = Const.CAR_OBJ_INIT_POSITION + 3;
        assertThat(new Car(carInitName,position)).isEqualTo(new Car(carInitName,position));
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
    void create_자동차_포지션_범위_예외() {
        int position = Const.CAR_OBJ_INIT_POSITION - 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carInitName,position);
        });
    }

    @Test
    void increase_자동차_포지션_증가일_경우() {
        car.increasePositionOrNot(4);
        assertThat(car.toString()).isEqualTo(carInitName + " : -");

    }

    @Test
    void increase_자동차_포지션_변화_없음() {
        car.increasePositionOrNot(3);
        assertThat(car.toString()).isEqualTo(carInitName + " : ");
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}