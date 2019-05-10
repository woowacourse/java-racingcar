package racingcargame.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {
    @Test
    void 차생성테스트() {
        assertThat(new Car("abc")).isEqualTo(new Car("abc"));
    }

    @Test
    void 차이름다섯자이상테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdef");
        });
    }

    @Test
    void 차이름공백이상테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 차정지테스트() {
        Car testCar = new Car("test");
        testCar.move(3);

        assertThat(testCar.matchPosition(0)).isEqualTo(true);
    }

    @Test
    void 차움직임테스트() {
        Car testCar = new Car("test");
        testCar.move(4);

        assertThat(testCar.matchPosition(1)).isEqualTo(true);
    }
}
