package racingTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.TrialTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTimeTest {

    @Test
    @DisplayName("문자가 입력될 경우 예외 처리")
    void checkNotNumberTest() {
        assertThatThrownBy(() -> {
            new TrialTime("가");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("null 입력될 경우 예외 처리")
    void checkTrialTimeNullTest() {
        assertThatThrownBy(() -> {
            new TrialTime(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessage("시도 횟수가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("공백이나 빈문자열 입력될 경우 예외 처리")
    void checkTrialTimeEmptyTest() {
        assertThatThrownBy(() -> {
            new TrialTime("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("음수가 입력될 경우 예외 처리")
    void checkTrialTimeNegativeTest() {
        assertThatThrownBy(() -> {
            new TrialTime("-2");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 음수가 입력될 수 없습니다.");
    }
}
