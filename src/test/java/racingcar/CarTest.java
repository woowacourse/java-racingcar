package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        Car car = new RandomMovingCar(carName, new RangedRandomNumberPicker(0, 9));

        // when
        String result = car.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }

    @RepeatedTest(100)
    void 자동차는_진행_가능_범위에서_진행할_수_있다() {
        // given
        final int FROM = 4;
        final int TO = 9;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @RepeatedTest(100)
    void 자동차는_진행_불가능_범위에서_진행할_수_없다() {
        // given
        final int FROM = 0;
        final int TO = 3;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
