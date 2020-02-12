package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름_부여() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 전진하기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(4)).isEqualTo(1);
    }

    @Test
    void 멈추기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(3)).isEqualTo(0);
    }

    @Test
    void 진행상황_출력() {
        Car car = new Car("pobi");
        car.movePosition(5);
        car.movePosition(5);
        car.movePosition(5);
        assertThat(car.currntPositon()).isEqualTo("pobi : ---");
    }
}
