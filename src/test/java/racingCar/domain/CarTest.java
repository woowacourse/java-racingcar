package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    Car car = new Car("jiwoo", 0);

    @Test
    void go_3넣으면_이동안함() {
        car.go(3);
        assertThat(car.position.get()).isEqualTo(0);
    }

    @Test
    void go_4넣으면_이동() {
        car.go(4);
        assertThat(car.position.get()).isEqualTo(1);
    }
}