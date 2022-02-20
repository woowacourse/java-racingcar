package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "", "  "})
    @DisplayName("검증에 걸리는 이름 검증시 에러 발생")
    void checkInvalidateValue(String name) {
        assertThatThrownBy(() -> CarNameValidator.validate(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
