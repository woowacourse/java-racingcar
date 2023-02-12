package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidatorTest {

    private Validator carNameValidator;

    @DisplayName("이름 입력 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "포비는너무멋져남자가봐도반하겠어", ",,,,,"})
    void validate(String input) {
        carNameValidator = new CarNameValidator();
        List<String> carNames = Arrays.asList(input.split(","));
        assertThatThrownBy(() -> carNameValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 1 ~ 5 글자로 입력해야합니다.");
    }
}