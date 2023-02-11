package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceedCarNameLengthException;
import racingcar.exception.HasBlankCarNameException;
import racingcar.exception.InvalidCarNameFormatException;
import racingcar.model.car.strategy.ForwardMovingStrategy;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이름이 공백인 경우 예외 처리가 되는지 테스트")
    @Test
    void validateHasBlankCarNameTest() {
        assertThatThrownBy(() -> {
            new Car("", new ForwardMovingStrategy());
        }).isInstanceOf(HasBlankCarNameException.class);
    }

    @DisplayName("자동차의 이름이 문자나 숫자가 아닐 경우 예외 처리가 되는지 테스트")
    @Test
    void validateCarNameFormatTest() {
        assertThatThrownBy(() -> {
            new Car("a.b asdf", new ForwardMovingStrategy());
        }).isInstanceOf(InvalidCarNameFormatException.class);
    }

    @DisplayName("자동차의 이름 길이가 범위를 벗어나면 예외 처리가 되는지 테스트")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> {
            new Car("woowacourse", new ForwardMovingStrategy());
        }).isInstanceOf(ExceedCarNameLengthException.class);
    }

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