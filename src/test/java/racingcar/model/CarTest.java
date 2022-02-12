package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_이동_확인() {
        Car car = new Car("bravo", 0, () -> 5);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    public void 자동차_중지_확인() {
        Car car = new Car("bravo", 0, () -> 1);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    public void 자동차_최대_위치_확인() {
        Car car = new Car("bravo", 7, () -> 1);
        assertThat(car.isMaxPosition(7)).isTrue();
    }
}
