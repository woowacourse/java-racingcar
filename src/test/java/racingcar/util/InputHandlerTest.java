package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputHandlerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_null_혹은_empty(String input) {
        assertThatThrownBy(() -> {
            InputHandler.isNullOrEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
