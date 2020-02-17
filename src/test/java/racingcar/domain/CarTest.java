package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Name name = new Name("pobi");
    Car car = new Car(name);

    @Test
    void 전진_또는_멈춤() {
        NumberGenerator number = new FixedNumber();
        assertThat(car.movePosition(number)).isEqualTo(1);
    }

    @Test
    void 현재_위치_가져오기() {
        car.movePosition(new FixedNumber());
        assertThat(car.getCurrentPosition()).isEqualTo("pobi : -");
    }

    @Test
    void Winner와_position이_같은지_테스트() {
        NumberGenerator number = new FixedNumber();
        Car car1 = new Car(new Name("pobi"));
        Car car2 = new Car(new Name("elly"));
        car1.movePosition(number);
        car2.movePosition(number);
        car1.isWinnerWith(car2);
    }
}
