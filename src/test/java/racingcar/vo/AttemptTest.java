package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptTest {

    @DisplayName("new Attempt() 테스트")
    @Test
    public void 생성자_test() throws Exception {
        String input = "3";
        Attempt attempt = new Attempt(input);
        assertThat(attempt.getAttempt()).isEqualTo(3);
    }

    @DisplayName("isLeft() 테스트")
    @Test
    public void isLeft_test() throws Exception {
        String inputZero = "0";
        String inputOne = "1";
        Attempt attemptZero = new Attempt(inputZero);
        Attempt attemptOne = new Attempt(inputOne);
        assertThat(attemptZero.isLeft()).isFalse();
        assertThat(attemptOne.isLeft()).isTrue();
    }

    @DisplayName("decrease() 테스트")
    @Test
    public void decrease_test() throws Exception {
        String input = "3";
        Attempt attempt = new Attempt(input);
        assertThat(attempt.getAttempt()).isEqualTo(3);
        attempt.decrease();
        assertThat(attempt.getAttempt()).isEqualTo(2);
        attempt.decrease();
        assertThat(attempt.getAttempt()).isEqualTo(1);
        attempt.decrease();
        assertThat(attempt.getAttempt()).isEqualTo(0);
    }

    @DisplayName("validNumberFormat() 입력 값이 숫자가 아닌 경우 예외 테스트")
    @Test
    public void 생성자_숫자가_아닌_입력_예외_test() throws Exception {
        String input = "abc";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("validNegative() 입력 값이 음수인 경우 예외 테스트")
    @Test
    public void 생성자_음수_minus_3_예외_test() throws Exception {
        String input = "-3";
        assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(RuntimeException.class);
    }
}
