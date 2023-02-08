package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryCountValidationTest {

    @Test
    @DisplayName("validateTryCount() : 이동 거리가 음수인 경우 IllegalArgumentException 발생")
    void test_ValidateTryCount_IllegalArgumentException() {
        // given
        int input = -1;

        // when & then
        assertThrows(IllegalArgumentException.class,
                     () -> TryCountValidation.validateTryCount(input));
    }

    @Test
    @DisplayName("validateTryCount() 성공 경우")
    void test_validateTryCount_success() {
        // given
        final int input = 3;

        // when, then
        TryCountValidation.validateTryCount(input);
    }

}