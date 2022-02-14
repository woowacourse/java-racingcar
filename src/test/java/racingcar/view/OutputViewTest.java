package racingcar.view;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void 결과_문자열을_생성한다() {
        // given
        final String expected = "---";
        final boolean moveForward = true;

        final Car car = new Car(new CarName("pobi"));
        car.attemptToMove(moveForward);
        car.attemptToMove(moveForward);

        //when
        final String result = OutputView.makePositionString(car.getPosition());

        //then
        assertThat(result).isEqualTo(expected);
    }
}
