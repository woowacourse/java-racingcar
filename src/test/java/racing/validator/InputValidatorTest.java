package racing.validator;

import org.junit.jupiter.api.Test;
import racing.utils.Helper;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void 입력없는이름확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("");});
    }

    @Test
    void 다섯글자이상이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("?*^&!");});
    }

    @Test
    void 실행횟수확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidExecution(0);
        });
    }

}