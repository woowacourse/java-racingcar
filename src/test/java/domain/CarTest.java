package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void create_Car() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void isMoveTest() {
        assertThat(Car.isMove(4)).isTrue();
        assertThat(Car.isMove(3)).isFalse();
    }

    @Test
    void isEqualPositionTest() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");

        assertThat(car1.isEqualPosition(car2)).isTrue();

        car1.move(4);
        assertThat(car1.isEqualPosition(car2)).isFalse();
    }
}
