package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceedCarNameLengthException;
import racingcar.exception.HasBlankCarNameException;
import racingcar.exception.InvalidCarNameFormatException;
import racingcar.model.car.strategy.TestMovingStrategy;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이름이 공백인 경우 예외 처리가 되는지 테스트")
    @Test
    void validateHasBlankCarNameTest() {
        assertThatThrownBy(() -> {
            new Car("", new TestMovingStrategy(new int[]{1}));
        }).isInstanceOf(HasBlankCarNameException.class);
    }

    @DisplayName("자동차의 이름이 문자나 숫자가 아닐 경우 예외 처리가 되는지 테스트")
    @Test
    void validateCarNameFormatTest() {
        assertThatThrownBy(() -> {
            new Car("a.b asdf", new TestMovingStrategy(new int[]{1}));
        }).isInstanceOf(InvalidCarNameFormatException.class);
    }

    @DisplayName("자동차의 이름 길이가 범위를 벗어나면 예외 처리가 되는지 테스트")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> {
            new Car("woowacourse", new TestMovingStrategy(new int[]{2}));
        }).isInstanceOf(ExceedCarNameLengthException.class);
    }

    @DisplayName("자동차의 현재 위치 형식 테스트")
    @Test
    void currentStateFormatTest() {
        // given
        Car pobi = new Car("pobi", new TestMovingStrategy(new int[]{6}));
        String expected = "pobi : -";

        // when
        String actual = String.format(OutputView.POSITION_CAR_STATE_FORMAT,
                pobi.getCarName(),
                OutputView.POSITION_CAR_FORMAT_SYMBOL.repeat(pobi.getPosition()));

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
