package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        assertThat(car).isEqualTo(new Car(carInitName, Const.CAR_OBJ_INIT_POSITION));
    }

    @Test
    void create_자동차_객체_생성_포지션() {
        int position = Const.CAR_OBJ_INIT_POSITION + 3;
        assertThat(new Car(carInitName, position)).isEqualTo(new Car(carInitName, position));
    }

    @Test
    void create_자동차_이름_5자이상_예외_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("123456");
        });
    }

    @Test
    void create_자동차_이름_빈값_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void create_자동차_포지션_범위_예외() {
        int position = Const.CAR_OBJ_INIT_POSITION - 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carInitName, position);
        });
    }

    @Test
    void isMatchPosition_확인() {
        assertTrue(new Car("hee", 5).isMatchPosition(5));
    }

    @Test
    void increase_자동차_포지션_증가일_경우() {
        car.increasePositionOrNot(4);
        assertTrue(car.isMatchPosition(Const.CAR_OBJ_INIT_POSITION + 1));
    }

    @Test
    void increase_자동차_포지션_변화_없음() {
        car.increasePositionOrNot(3);
        assertTrue(car.isMatchPosition(Const.CAR_OBJ_INIT_POSITION));
    }

    @Test
    void Sort_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hi", 1));
        cars.add(new Car("my", 1));
        cars.add(new Car("name", 4));
        cars.add(new Car("is", 5));
        Car max = cars.stream().max(Car::compareTo).get();
        assertThat(max).isEqualTo(new Car("is", 5));
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}