package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car1 = new Car("car1");

    @Test
    void 자동차_생성() {
        assertThat(car1).isNotNull();
    }

    @Test
    void 자동차_이동() {
        final int currentPosition = car1.getPosition();
        car1.move(7);
        final int nextPosition = car1.getPosition();
        assertThat(nextPosition).isEqualTo(currentPosition + 1);
    }

    @Test
    void 자동차_멈춤() {
        int currentPosition = car1.getPosition();
        car1.move(3);
        final int nextPosition = car1.getPosition();
        assertThat(nextPosition).isEqualTo(currentPosition);
    }

    @Test
    void 자동차_위치_비교() {
        Car car2 = new Car("car2");
        int goNumber = 4;
        car2.move(goNumber);
        assertThat(car1.compareTo(car2) < 0).isTrue();
    }
}
