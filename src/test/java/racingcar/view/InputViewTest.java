package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        return new String[] {"", null};
    }
}