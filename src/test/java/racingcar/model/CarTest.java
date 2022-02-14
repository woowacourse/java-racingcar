package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_이동_확인() {
        Car car = new Car("bravo", 0);
        boolean actual = car.isMovable(() -> 5);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void 자동차_중지_확인() {
        Car car = new Car("bravo", 0);
        boolean actual = car.isMovable(() -> 3);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void 자동차_최대_위치_확인() {
        Car car = new Car("bravo", 7);
        assertThat(car.isMaxPosition(7)).isTrue();
    }
}
