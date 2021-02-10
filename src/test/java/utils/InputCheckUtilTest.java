package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.InputCheckUtil;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputCheckUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {",apple,pear", "apple,pear,"})
    void inputValidate(String input) {
        assertThatThrownBy(() -> {
            InputCheckUtil.inputValidate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작이나 끝에 콤마(,)가 올 수 없습니다.");
    }

}