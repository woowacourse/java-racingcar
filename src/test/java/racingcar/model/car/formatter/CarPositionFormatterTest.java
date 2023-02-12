package racingcar.model.car.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.strategy.ForwardMovingStrategy;

class CarPositionFormatterTest {

    @DisplayName("자동차 위치 출력 형식 테스트")
    @Test
    void formatCarPositionTest() {
        //given
        Car pobi = new Car("pobi", new ForwardMovingStrategy());
        CarPositionFormatter carPositionFormatter = new CarPositionFormatter();
        String expectedFormat = "pobi : ---";

        //when
        pobi.moveForward();
        pobi.moveForward();
        String actual = carPositionFormatter.format(pobi);

        //then
        assertThat(actual).isEqualTo(expectedFormat);
    }

}
