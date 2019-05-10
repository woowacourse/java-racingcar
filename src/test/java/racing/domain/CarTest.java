package racing.domain;

import org.junit.jupiter.api.Test;

import racing.controller.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 생성자올바른예확인() {
        assertThat(new Car("Buddy")).isEqualTo(new Car("Buddy"));
    }

    @Test
    void 생성자이름입력예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 전진멈춤확인() {
        assertThat(Controller.move(3)).isEqualTo(false);
    }

    @Test
    void 포지션결과문자열생성기() {
        Car car = new Car("pobi", 4);
        String expectation = "pobi : ----\n";
        assertThat(car.positionResult()).isEqualTo(expectation);
    }

    @Test
    void 카의스테이터스비교가잘되나요1() {
        Car car1 = new Car("Buddy", 10);
        Car car2 = new Car("Luffy", 3);
        assertThat(car1.compareTo(car2)).isEqualTo(1);
    }

    @Test
    void 카의스테이터스비교가잘되나요2() {
        Car car1 = new Car("Buddy", 3);
        Car car2 = new Car("Luffy", 10);
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }

    @Test
    void 카의스테이터스비교가잘되나요3() {
        Car car1 = new Car("Buddy", 5);
        Car car2 = new Car("Luffy", 5);
        assertThat(car1.compareTo(car2)).isEqualTo(0);
    }

    @Test
    void 포지션설정이잘됐나요() {
        Car car1 = new Car("Buddy", 5);
        assertThat(car1.matchPosition(5)).isEqualTo(true);
    }
}