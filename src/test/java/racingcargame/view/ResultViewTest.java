package racingcargame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    @Test
    @DisplayName("올바른 길이의 막대가 생성되는지 테스트")
    void bar() {
        assertThat(ResultView.bar(3)).isEqualTo("---");
    }
}
