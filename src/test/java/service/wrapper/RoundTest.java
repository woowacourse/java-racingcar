package service.wrapper;

import exception.WrongRoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"'", "ab", ":"})
    @DisplayName("숫자가 아닌 값을 입력하면 WrongRoundException 예외가 발생한다.")
    void wrongNumberFormat(String wrongInput) {
        Assertions.assertThatThrownBy(() -> new Round(wrongInput))
                .isInstanceOf(WrongRoundException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("0 이하의 값을 입력하면 WrongRoundException 예외가 발생한다.")
    void wrongNumberRange(String wrongInput) {
        Assertions.assertThatThrownBy(() -> new Round(wrongInput))
                .isInstanceOf(WrongRoundException.class);
    }
}