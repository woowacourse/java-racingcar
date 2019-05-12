package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racing.utils.Helper.moveOrNot;

class CarTest {
    @Test
    void 객체생성() {
        assertThat(new Car("Buddy")).isEqualTo(new Car("Buddy",0));
    }

    @Test
    void 차이름예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 전진멈춤확인() {
        assertThat(moveOrNot(3)).isEqualTo(false);
    }

    @Test
    void 차이동결과() {
        Car car = new Car("pobi", 4);
        String expectation = "pobi : ----\n";
        assertThat(car.positionResult()).isEqualTo(expectation);
    }

    @Test
    void 이동값비교() {
        Car car1 = new Car("Buddy", 5);
        Car car2 = new Car("Luffy", 6);
        assertThat(car1.compareTo(car2)).isEqualTo(1);
    }

    @Test
    void 이동값확인() {
        Car car1 = new Car("Buddy", 5);
        assertThat(car1.matchPosition(5)).isEqualTo(true);
    }
}