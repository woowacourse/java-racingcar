package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {


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
                .isInstanceOf(IllegalArgumentException.class);

        String inputNumber = "1";
        int result = 1;
        assertThat(result).isEqualTo(ValidateInput.ValidateCount(inputNumber));
    }
}
