package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class InputValidatorTest {

    @DisplayName("정수가 아닌 값 검증 테스트")
    @Test
    void validateTryCountTest() {
        assertThatThrownBy(() -> {
            InputValidator.validateTryCount("일");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("이름 공백 검증 테스트")
    @Test
    void validateNameTest1() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("이름 길이 검증 테스트")
    @Test
    void validateNameTest2() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("abcdef");
        }).isInstanceOf(RuntimeException.class);
    }
}
