package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepeatTest {

    @Test
    @DisplayName("시도할 회수가 숫자 형식이 아닌 경우 익셉션을 제대로 처리하는지 테스트")
    void repeatFormatTest() {
        assertThatThrownBy(() -> {
            new Repeat("abc");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도할 횟수는 숫자로 입력해주세요.");
    }

    @Test
    @DisplayName("시도할 회수가 0 이하인 경우 익셉션을 제대로 처리하는지 테스트")
    void repeatLimitTest() {
        assertThatThrownBy(() -> {
            new Repeat("0");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도할 횟수는 양수여야 합니다.");
    }
}
