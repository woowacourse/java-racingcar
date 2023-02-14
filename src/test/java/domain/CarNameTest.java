package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름")
public class CarNameTest {

    @DisplayName("공백이 포함되어 글자가 1 ~ 5 글자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"  pobi   ", "  hello  ", " 제이미짱! "})
    void validateCarNameSuccess(String input) {
        Assertions.assertDoesNotThrow(() -> new CarName(input));
    }

    @DisplayName("공백이 포함되어 글자가 1 ~ 5 글자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"  pobiss   ", "    ", " 제이미짱!! "})
    void validateCarNameFail(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 1 ~ 5 글자로 입력해야합니다.");
    }

}
