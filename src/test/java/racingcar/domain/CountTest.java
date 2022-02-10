package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("시도가 가능한 경우 true를 반환하다.")
    @Test
    void isPositive_count_양수() {
        // given
        String input = "5";

        // when
        Count count = new Count(input);

        // then
        assertThat(count.isPositive()).isTrue();
    }

    @DisplayName("시도가 불가능한 경우 false를 반환하다.")
    @Test
    void isPositive_count_0이하() {
        // given
        String input = "0";

        // when
        Count count = new Count(input);

        // when & then
        assertThat(count.isPositive()).isFalse();
    }

    @DisplayName("count 차감이 정상적으로 되는지 확인한다.")
    @Test
    void subtract_count_차감() {
        // given
        Count count = new Count("5");

        // when
        count.subtract();

        // then
        assertThat(count.isPositive()).isTrue();
    }
}