package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @DisplayName("시도할 횟수가 정상적으로 입력되면 생성된다.")
    @Test
    void constructor_숫자() {
        // given
        String input = "5";

        // when & then
        assertThatCode(() -> {
            new Count(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("시도할 횟수가 숫자 이외의 값인 경우 예외를 throw 한다.")
    @Test
    void constructor_숫자아님() {
        // given
        String input = "매트";

        // when & then
        assertThatThrownBy(() -> {
            new Count(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수가 음수인 경우 예외를 throw 한다.")
    @Test
    void constructor_음수() {
        // given
        String input = "-7";

        // when & then
        assertThatThrownBy(() -> {
            new Count(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}