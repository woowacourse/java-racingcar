package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("validateNames 메서드는 올바른 차 이름인지 확인하고 이름 목록을 반환한다.")
    void should_returnValidNames_when_validateInput() {
        String input = "도기,다즐,허브";

        List<String> result = inputValidator.validateNames(input);

        assertThat(result).containsExactly("도기", "다즐", "허브");
    }

    @ParameterizedTest
    @ValueSource(strings = {"h", "Q", "한", "!", "", "-1", "0", "1.2"})
    @DisplayName("정수로 변환할 수 없거나, 1이상의 정수가 아닌 경우 예외를 던진다.")
    void should_throwException_when_invalidCount(final String input) {
        assertThatThrownBy(() -> inputValidator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 1이상의 정수만 가능합니다.");
    }
}
