package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {

    @Test
    @DisplayName("이름이 다섯글자 이내인지 판단")
    void checkNameLength() {
        String[] name = new String[]{"a", "fghsdtsdt", "12", "sdfs"};
        assertThatThrownBy(() -> ValidateInput.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 숫자가 0보다 큰지 확인")
    @Test
    void isOverZero() {
        int count = 0;
        boolean result = ValidateInput.isOverZero(count);
        assertThat(result).isFalse();
    }

    @DisplayName("입력 라운드 숫자 유효성 검사 테스트")
    @Test
    void inputCount() {
        String input = "a";
        assertThatThrownBy(() -> ValidateInput.ValidateCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자를 입력하였습니다.");

        String inputNumber = "1";
        int result = 1;
        assertThat(result).isEqualTo(ValidateInput.ValidateCount(inputNumber));
    }
}
