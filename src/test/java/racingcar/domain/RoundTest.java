package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @Test
    @DisplayName("시도할 횟수에 문자를 입력하면 NumberFormatException을 발생시킨다.")
    public void roundShouldBeNumber() {
        assertThatThrownBy(() -> {
            Round.of("a");
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest(name = "시도할 횟수는 1이상의 숫자여야 한다")
    @ValueSource(strings = {"0", "-1", "-5"})
    public void roundCountShouldBeBiggerThanOneTest(String values) {
        assertThatThrownBy(() -> {
            Round.of(values);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수에 int 타입의 범위를 넘어선 값을 입력하면 NumberFormatException을 발생시킨다.")
    public void roundCountShouldBeInIntRange() {
        assertThatThrownBy(() -> {
            String str = "100000000000000000000";
            Round.of(str);
        }).isInstanceOf(NumberFormatException.class);
    }
}
