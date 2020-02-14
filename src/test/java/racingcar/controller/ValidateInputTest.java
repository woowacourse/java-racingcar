package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidateInputTest {

    @DisplayName("이름이 다섯글자 이내인지 판단")
    @Test
    void checkNameLength() {
        String[] name = new String[]{"a", "fghsdtsdt", "12", "sdfs"};
        assertThatThrownBy(() -> ValidateInput.validateName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1이상 5이하만 가능합니다");

        String[] name2 = new String[]{"a", "", "12", "sdfs"};
        assertThatThrownBy(() -> ValidateInput.validateName(name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1이상 5이하만 가능합니다");
    }

    @DisplayName("입력한 숫자가 0보다 큰지 확인")
    @Test
    void isOverZero() {
        int count = 0;
        boolean result = ValidateInput.isUnderZero(count);
        assertThat(result).isTrue();
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
