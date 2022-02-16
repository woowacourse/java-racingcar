package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptTest {

    @DisplayName("Attempt() 테스트")
    @Test
    public void constructor_test() throws Exception {
        String input = "3";
        Attempt attempt = new Attempt(input);
        assertThat(attempt.get()).isEqualTo(3);
    }

    @ParameterizedTest(name = "isLeft() 테스트 : {0}")
    @ValueSource(strings = {"0"})
    public void has_false_test(String input) throws Exception {
        Attempt attempt = new Attempt(input);
        assertThat(attempt.isLeft()).isFalse();
    }

    @ParameterizedTest(name = "isLeft() 테스트 : {0}")
    @ValueSource(strings = {"1", "10"})
    public void has_true_test(String input) throws Exception {
        Attempt attempt = new Attempt(input);
        assertThat(attempt.isLeft()).isTrue();
    }

    @ParameterizedTest(name = "decrease() 테스트 : {0}")
    @ValueSource(strings = {"1", "3", "10"})
    public void decrease_test(String input) throws Exception {
        Attempt attempt = new Attempt(input);
        attempt.decrease();
        int decreasedNumber = Integer.parseInt(input) - 1;
        assertThat(attempt.get()).isEqualTo(decreasedNumber);
    }

    @DisplayName("validNumberFormat() 문자 입력 예외 테스트")
    @Test
    public void non_number_input_exception_test() throws Exception {
        String input = "abc";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("validNegative() 음수 입력 예외 테스트")
    @Test
    public void negative_input_exception_test() throws Exception {
        String input = "-3";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(RuntimeException.class);
    }
}
