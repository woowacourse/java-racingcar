package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    public static final int MOVED_POSITION = Car.INIT_POSITION + 1;
    public static final int STOP_POSITION = Car.INIT_POSITION;
    private final Car car1 = new Car("car1");

    @Test
    void 자동차_생성() {
        assertThat(car1).isNotNull();
    }

    @Test
    void 자동차_이동() {
        car1.move(7);
        int currentPosition = car1.getPosition();
        assertThat(currentPosition).isEqualTo(MOVED_POSITION);
    }

    @Test
    void 자동차_멈춤() {
        car1.move(3);
        int currentPosition = car1.getPosition();
        assertThat(currentPosition).isEqualTo(STOP_POSITION);
    }

    @Test
    void 자동차_위치_비교() {
        Car car2 = new Car("car2");
        int go = 4;
        car2.move(go);
        assertThat(car1.compareTo(car2) < 0).isTrue();
    }
}
