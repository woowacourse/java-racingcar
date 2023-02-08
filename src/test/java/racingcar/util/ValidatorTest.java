package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("차 이름 공백 입력")
    void carBlank() {

        assertThatThrownBy(() -> Validator.validateCarNames(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름 다섯글자 이상 입력")
    void carRange() {

        assertThatThrownBy(() -> Validator.validateCarNames("aaaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("시도 횟수 공백 입력")
    void tryBlank() {
        assertThatThrownBy(() -> Validator.validateGameTime(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 음수 입력")
    void tryNegative() {
        assertThatThrownBy(() -> Validator.validateGameTime("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 글자 입력")
    void tryNotInteger() {
        assertThatThrownBy(() -> Validator.validateGameTime("정수아님"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}