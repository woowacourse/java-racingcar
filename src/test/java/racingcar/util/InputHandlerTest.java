package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 자동자가_5대_초과로_오는_경우() {
        int carCount = 6;
        assertThatThrownBy(() -> {
            InputHandler.validateCarCount(carCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 5대 초과");

    }
}
