package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Name name = new Name("pobi");
    Car car = new Car(name);

    @Test
    void 전진_또는_멈춤() {
        assertThat(car.movePosition(5)).isEqualTo(1);
        assertThat(car.movePosition(3)).isEqualTo(0);
    }

    @Test
    void 현재_위치_가져오기() {
        car.movePosition(5);
        assertThat(car.getCurrentPosition()).isEqualTo("pobi : -");
    }

    @Test
    void Winner와_position이_같은지_테스트() {
        Car car1 = new Car(new Name("pobi"));
        Car car2 = new Car(new Name("elly"));
        car1.movePosition(5);
        car2.movePosition(5);
        car1.isSamePositionWith(car2);
    }
}
