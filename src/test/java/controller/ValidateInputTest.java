package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    @DisplayName("이름이 다섯글자 이내인지 판단")
    void checkNameLength() {
        String[] name = new String[]{"a", "fgh", "12", "sdfs"};
        boolean result = ValidateInput.checkNameLength(name);
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 숫자가 0보다 큰지 확인")
    @Test
    void isOverZero() {
        int count = -1;
        boolean result = ValidateInput.isOverZero(count);
        assertThat(result).isFalse();
    }
}
