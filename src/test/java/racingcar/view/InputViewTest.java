package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ParameterizedTest
    @MethodSource("createNullAndEmpty")
    void validateEmpty(String input) {
        assertThatThrownBy(() -> {
            InputView.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 없습니다.");
    }

    private static String[] createNullAndEmpty() {
        return new String[] {InputView.EMPTY, null};
    }
}