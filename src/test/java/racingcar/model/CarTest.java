package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_이동_확인() {
        Car car = new Car("bravo", 0);
        car.move(() -> 5);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void 자동차_이동__경계값_확인() {
        Car car = new Car("bravo", 0);
        car.move(() -> 4);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void 자동차_중지_확인() {
        Car car = new Car("bravo", 0);
        car.move(() -> 3);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void 자동차_최대_위치_확인() {
        Car car = new Car("bravo", 7);
        assertThat(car.isMaxPosition(7)).isTrue();
    }
}
