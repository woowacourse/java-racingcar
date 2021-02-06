package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameBlankOrEmptyException;
import racingcar.exception.CarNameLengthException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5자 이하가 아니면 예외")
    @ValueSource(strings = {"qqqqqq", "qqqqqqq", "qdssdq"})
    public void getCarNames_자동차_이름은_5자_이하가_아니면_예외(String input) {
        assertThatExceptionOfType(CarNameLengthException.class).isThrownBy(
                () -> new CarName(input)
        ).withMessageContaining(new CarNameLengthException().getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 빈값이 들어오면 예외")
    @ValueSource(strings = {"", " ", "  ", "     "})
    public void getCarNames_자동차_이름에_빈값이_들어오면_예외(String input) {
        assertThatExceptionOfType(CarNameBlankOrEmptyException.class).isThrownBy(
                () -> new CarName(input)
        ).withMessageContaining(new CarNameBlankOrEmptyException().getMessage());
    }
}
