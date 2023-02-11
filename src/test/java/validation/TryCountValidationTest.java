package validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1})
    @DisplayName("validateTryCount() 실패 경우")
    void test_validateTryCount_fail(int input) {
        // given
        String expectedMessage = "0 이상의 수를 입력해주세요.";

        // when, then
        assertThatThrownBy(() -> TryCountValidation.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("validateTryCount() 성공 경우")
    void test_validateTryCount_success(int input) {
        // when & then
        TryCountValidation.validateTryCount(input);
    }
}
