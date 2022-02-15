package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    @DisplayName("출력에 사용할 결과 문자열을 생성한다")
    void shouldReturnResultString() {
        // given
        String expected = "---";
        Car car = new Car("pobi");
        car.attemptToMove(4);
        car.attemptToMove(4);

        //when
        String result = OutputView.makePositionString(car);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
