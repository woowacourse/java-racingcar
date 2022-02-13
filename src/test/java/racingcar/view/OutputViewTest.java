package racingcar.view;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void 결과_문자열을_생성한다() {
        // given
        String expected = "---";

        Car car = new Car(new CarName("pobi"));
        car.attemptToMove(4);
        car.attemptToMove(4);

        //when
        String result = OutputView.makePositionString(car);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
