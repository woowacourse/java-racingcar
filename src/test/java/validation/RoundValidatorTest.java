package validation;

import domain.validation.RoundValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundValidatorTest {
    @ParameterizedTest
    @ValueSource(ints ={1, 2, 50, 99, 100})
    @DisplayName("라운드 테스트 : 정상 범위의 시도 횟수를 입력할 때")
    void validateRound_validateInputs(int validInput) {
        assertDoesNotThrow(() -> RoundValidator.validateRound(validInput));
    }

    @ParameterizedTest
    @ValueSource(ints ={0, -1, 101, 102})
    @DisplayName("라운드 테스트 : 예외 범위의 시도 횟수를 입력할 때")
    void validateRound_invalidateInputs(int invalidInput) {
        assertThrows(IllegalArgumentException.class,
                () -> RoundValidator.validateRound(invalidInput));
    }
}
