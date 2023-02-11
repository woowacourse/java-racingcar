package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.ForwardMovingStrategy;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차의 현재 위치 형식 테스트")
    @Test
    void currentStateFormatTest(){
        // given
        Car car = new Car("pobi", new ForwardMovingStrategy());
        String expected = "pobi : -";

        // when
        String actual = String.format(OutputView.POSITION_CAR_STATE_FORMAT,
                car.getCarName(),
                OutputView.POSITION_CAR_FORMAT_SYMBOL.repeat(car.getPosition()));

        // then
        assertThat(actual).isEqualTo(expected);
    };

}