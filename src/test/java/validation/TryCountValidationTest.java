package validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountValidationTest {

    @Test
    @DisplayName("validateTryCount() : 이동 거리가 음수인 경우 IllegalArgumentException 발생")
    void test_ValidateTryCount_IllegalArgumentException() {
        // given
        int input = -1;
        String expectedMessage = "0 이상의 수를 입력해주세요.";

        // when & then
        assertThatThrownBy(() -> TryCountValidation.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
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
