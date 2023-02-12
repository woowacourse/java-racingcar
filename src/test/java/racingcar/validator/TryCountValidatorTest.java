package racingcar.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TryCountValidatorTest {
    private static TryCountValidator tryCountValidator;

    @BeforeAll
    static void set() {
        tryCountValidator = new TryCountValidator();
    }

    @ParameterizedTest()
    @DisplayName("횟수 유효성 검사 테스트")
    @ValueSource(strings = {"1", "3", "9", "100", "300", "500"})
    public void 횟수_유효성_검사(String tryCount) {
        assertDoesNotThrow(() -> tryCountValidator.validateTryCount(tryCount));
    }

    @ParameterizedTest()
    @DisplayName("횟수가 자연수가 아닐 경우 예외 테스트")
    @ValueSource(strings = {"a", "0", "-100", "1abc", "테스트"})
    public void 횟수_예외_검사(String tryCount) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                tryCountValidator.validateTryCount(tryCount)
        );
        assertEquals("시도할 횟수는 자연수만 가능합니다.", exception.getMessage());
    }
}