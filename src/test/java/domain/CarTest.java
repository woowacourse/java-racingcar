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
        Car car = new Car("pobi");

        assertThat(car.isMove(4)).isTrue();
        assertThat(car.isMove(3)).isFalse();
    }

    @Test
    void moveTest() {
        Car car = new Car("pobi");

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
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
