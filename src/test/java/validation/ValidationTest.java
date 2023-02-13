package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    Validation validation = new Validation();

    @DisplayName("빈 값을 입력한 경우에 대한 예외 발생 테스트")
    @Test
    void inputEmptyExceptionTest() {
        assertThatThrownBy(() -> {
            validation.validateCarNames("");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("[ERROR]");
    }

    @DisplayName("띄어쓰기 값만 입력한 경우에 대한 예외 발생 테스트")
    @Test
    void inputBlankExceptionTest() {
        assertThatThrownBy(() -> {
            validation.validateCarNames("    ");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "시도 횟수 예외 발생 입력 테스트, tryCount = {0}")
    @ValueSource(ints = {-1, 0})
    void inputExceptionNumberTest(int tryCount) {
        assertThatThrownBy(() -> {
            validation.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("[ERROR]");
    }
}
