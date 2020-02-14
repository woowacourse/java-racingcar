package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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