package view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings={",apple,pear","apple,pear,"})
    void inputValidate(String input) {
        assertThatThrownBy(() -> {
            InputView.inputValidate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작이나 끝에 콤마(,)가 올 수 없습니다.");
    }

}