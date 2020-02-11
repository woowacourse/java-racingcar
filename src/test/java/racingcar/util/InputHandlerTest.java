package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputHandlerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_null_혹은_empty(String input) {
        assertThatThrownBy(() -> {
            InputHandler.validateNullOrEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값 혹은 Null");
    }

    @Test
    void 이름이_5자_초과() {
        String name = "아무거나 입력했어요";
        assertThatThrownBy(() -> {
            InputHandler.validateNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이 5자 초과");
    }

    @Test
    void 횟수가_10번_초과() {
        int count = 11;
        assertThatThrownBy(() -> {
            InputHandler.validateCount(count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수 10번 초과");
    }

    @Test
    void 횟수가_숫자가_아닌_경우() {
        String count = "a";
        assertThatThrownBy(() -> {
            InputHandler.validateNumber(count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 횟수 입력");
    }
}
