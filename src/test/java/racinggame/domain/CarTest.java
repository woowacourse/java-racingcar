package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 객체가_제대로_생상되는지_테스트() {
        assertThat(new Car("turt")).isEqualTo(new Car("turt"));
    }

    @Test
    void 차_이름이_공백인_경우_예외를_잘_던지는지_테스트() {
        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void 차_이름_길이가_6_이상일_때_예외를_잘_던지는지_테스트() {
        /* Then */
        assertThat(new Car("55555")).isEqualTo(new Car("55555"));
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("666666");
        });
    }

    @Test
    void 랜덤숫자가_4이상일때만_움직이는지_테스트() {
        /* Given */
        Car car = new Car("test");

        /* Then */
        assertTrue(car.run(4));
        assertTrue(car.run(9));
        assertFalse(car.run(0));
        assertFalse(car.run(3));
    }

    @Test
    void 차가_자기_히스토리를_제대로_만드는지_테스트() {
        /* Given */
        final Car car = new Car("test");
        HashMap<String, Integer> carHistory;

        /* When */
        carHistory = car.makeCarHistory();

        /* Then */
        assertThat(carHistory.containsKey("test")).isTrue();
        assertThat(carHistory.get("test")).isEqualTo(0);
    }
}