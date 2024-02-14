package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.ErrorMessage.CAR_NAME_TOO_LONG;
import static utils.ErrorMessage.NOT_POSITIVE_NUMBER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    public void tooLongCarNamesThrowException() {
        assertThatThrownBy(() -> InputValidator.carNamesValidator("명오배키켬미"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_TOO_LONG);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다.")
    public void notNumberTryNumberThrowException() {
        assertThatThrownBy(() -> InputValidator.tryNumberValidator("배키"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_NUMBER);
    }

    @Test
    @DisplayName("시도 횟수가 양수가 아니면 예외가 발생한다.")
    public void notPositiveTryNumberThrowException() {
        assertThatThrownBy(() -> InputValidator.tryNumberValidator("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_NUMBER);
    }
}