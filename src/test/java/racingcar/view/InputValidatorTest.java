package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest(name = "validateNames 메서드는 허용되지 않는 길이의 이름[{0}]을 입력받는 경우 예외를 던진다.")
    @ValueSource(strings = {"", "Dazzle"})
    void should_throwException_when_invalidNames(final String name) {
        assertThatThrownBy(() -> inputValidator.validateNames(List.of(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("validateNames 메서드는 올바른 길이의 차 이름 목록을 입력받는 경우 예외를 던지지 않는다.")
    void should_noException_when_validNames() {
        List<String> names = List.of("차", "다즐", "라틴어수업");

        assertThatNoException().isThrownBy(() -> inputValidator.validateNames(names));
    }

    @Test
    @DisplayName("validateNames 메서드는 중복된 이름이 포함된 이름 목록을 받는 경우 예외를 던진다.")
    void should_throwException_when_duplicatedNames() {
        final List<String> duplicatedNames = List.of("다즐", "허브", "허브");

        assertThatThrownBy(() -> inputValidator.validateNames(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 차 이름이 없어야 합니다.");
    }

    @ParameterizedTest(name = "validateCount 메서드는 1 ~ 100 사이의 정수가 아닌 값을 입력받는 경우 예외를 던진다. 입력값: {0}")
    @ValueSource(ints = {0, -1, 101})
    void should_throwException_when_invalidCount(final int count) {
        assertThatThrownBy(() -> inputValidator.validateCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1이상, 100이하의 정수여야 합니다.");
    }

    @ParameterizedTest(name = "validateCount 메서드는 1 ~ 100 사이의 정수를 입력받는 경우 예외를 던지지 않는다. 입력값: {0}")
    @ValueSource(ints = {1, 50, 100})
    void should_noException_when_validCount(final int count) {
        assertThatNoException().isThrownBy(() -> inputValidator.validateCount(count));
    }
}
