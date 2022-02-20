package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptTest {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "시도 회수는 숫자로 입력해야합니다.";
    private static final String NUMBER_NEGATIVE_ERROR_MESSAGE = "시도 회수는 0이상이어야 합니다.";

    @DisplayName("Attempt(String input) 테스트")
    @Test
    public void constructor_string_test() throws Exception {
        String input = "3";
        Attempt attempt = new Attempt(input);
        assertThat(attempt.equals(new Attempt(input))).isTrue();
    }

    @DisplayName("Attempt(int input) 테스트")
    @Test
    public void constructor_int_test() throws Exception {
        int input = 3;
        Attempt attempt = new Attempt(input);
        assertThat(attempt.equals(new Attempt(input))).isTrue();
    }

    @DisplayName("validNumberFormat() 문자 입력 예외 테스트")
    @Test
    public void non_number_input_exception_test() throws Exception {
        String input = "abc";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @DisplayName("validNegative() 음수 입력 예외 테스트")
    @Test
    public void negative_input_exception_test() throws Exception {
        String input = "-3";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_NEGATIVE_ERROR_MESSAGE);
    }
}
