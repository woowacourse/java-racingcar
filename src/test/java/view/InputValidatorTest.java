package view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {",  ,", "", "   ,안녕", "우아한테코톡"})
    @DisplayName("validateNames 메서드는 올바른 차 이름이 아니라면 예외를 던진다.")
    void should_throwException_when_invalidNames(final String input) {
        assertThatThrownBy(() -> inputValidator.validateNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상 ~ 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"도기,다즐,허브"})
    @DisplayName("validateNames 메서드는 올바른 차 이름이면 예외를 던지지 않는다.")
    void should_noException_when_validNames(final String input) {
        assertThatNoException().isThrownBy(() -> inputValidator.validateNames(input));
    }
}
