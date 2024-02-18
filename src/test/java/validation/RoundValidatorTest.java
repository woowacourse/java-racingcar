package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundValidatorTest {
    @Test
    @DisplayName("라운드 테스트 : 정상입력")
    void validateRound_validateInputs() {
        // given
        int[] validateInputs = {1, 2, 50, 99, 100};

        // when - then
        for (int validateInput : validateInputs) {
            assertDoesNotThrow(() -> RoundValidator.validateRound(validateInput));
        }
    }

    @Test
    @DisplayName("라운드 테스트 : 예외입력")
    void validateRound_invalidateInputs() {
        // given
        int[] invalidateInputs = {0, -1, 101, 102};

        // when - then
        for (int invalidateInput : invalidateInputs) {
            assertThrows(IllegalArgumentException.class,
                    () -> RoundValidator.validateRound(invalidateInput));
        }
    }
}
