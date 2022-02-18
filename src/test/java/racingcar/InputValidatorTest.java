package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @DisplayName("자동차 이름 목록에 구분자가 잘못 입력된 경우 에러 발생")
    @Test
    public void carName_pattern_regex_test() {
        String input = "hello.test,char";

        assertThatThrownBy(() -> {
            inputValidator.isValidPattern(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 영어와 쉼표로만 가능합니다.");
    }

    @DisplayName("자동차 이름 목록에 영문자가 아닌 값이 입력된 경우 에러 발생")
    @Test
    public void carName_pattern_alphabet_test() {
        String input = "hello,test,사빈";

        assertThatThrownBy(() -> {
            inputValidator.isValidPattern(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 영어와 쉼표로만 가능합니다.");
    }

    @DisplayName("자동차 이름 목록에 중복된 이름이 입력된 경우 에러 발생")
    @Test
    public void carName_duplicate_test() {
        String[] input = {"hello", "test", "hello"};

        assertThatThrownBy(() -> {
            inputValidator.isDuplicate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 중복이 불가능합니다.");
    }

    @DisplayName("시도 횟수에 숫자가 아닌 값이 입력된 경우 에러 발생")
    @Test
    public void attempt_numeric_test() {
        String input = "a";

        assertThatThrownBy(() -> {
            inputValidator.isNumeric(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 숫자만 가능합니다.");
    }

    @DisplayName("시도 횟수에 음수 입력된 경우 에러 발생")
    @Test
    public void attempt_minus_test() {
        int input = -1;

        assertThatThrownBy(() -> {
            inputValidator.isNaturalNumber(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 1 이상의 값만 입력이 가능합니다.");
    }

    @DisplayName("시도 횟수에 자연수가 아닌 값이 입력된 경우 에러 발생")
    @Test
    public void attempt_zero_test() {
        int input = 0;

        assertThatThrownBy(() -> {
            inputValidator.isNaturalNumber(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 1 이상의 값만 입력이 가능합니다.");
    }
}
