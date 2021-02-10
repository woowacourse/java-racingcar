package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("경주할 자동차 이름 저장")
    public void getNameTest() {
        Car car = Car.of(Name.valueOf("test"));

        assertThat(car).isEqualTo(Car.of(Name.valueOf("test")));
    }

    @Test
    @DisplayName("숫자가 4이상이면 자동차가 전진한다.")
    public void moveCarTest() {
        //given
        Car car = Car.of(Name.valueOf("test"));

        //when
        car.tryToMove(4);

        //then
        assertThat(car).isEqualTo(Car.of(Name.valueOf("test"), Position.valueOf(1)));
    }
}
