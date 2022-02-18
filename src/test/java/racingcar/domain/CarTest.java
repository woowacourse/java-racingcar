package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 랜덤값이_4이상이_나오면_자동차_이동() {
        Car car = new Car("bravo", () -> 5);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    public void 랜덤값이_4미만이_나오면_자동차_중지() {
        Car car = new Car("bravo", () -> 1);
        int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
