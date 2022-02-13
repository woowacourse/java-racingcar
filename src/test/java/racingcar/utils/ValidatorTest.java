package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.Validator.toInt;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 횟수_입력_성공() {
        int result = toInt("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 횟수_문자_입력_실패() {
        assertThatThrownBy(() ->
                toInt("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    void 횟수_음수_입력_실패() {
        assertThatThrownBy(() ->
                toInt("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 1 이상이어야 합니다.");
    }

}
