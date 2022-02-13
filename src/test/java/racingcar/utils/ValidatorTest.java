package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.Validator.toInt;
import static racingcar.utils.Validator.validateBlank;
import static racingcar.utils.Validator.validateDuplicateName;
import static racingcar.utils.Validator.validateEachCarName;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 이름_빈칸_실패() {
        assertThatThrownBy(() ->
                validateBlank("jae ,hun,choi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 공백이 존재합니다.");
    }

    @Test
    void 자동차_개수_초과_실패() {
        assertThatThrownBy(() ->
                validateEachCarName(new String[]{"jae ", "hun", "ab", "cd", "ef", "gh"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 이름_길이_초과_실패() {
        assertThatThrownBy(() ->
                validateEachCarName(new String[]{"jae ", "hunnnnnn", "jake"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하이어야 합니다.");
    }

    @Test
    void 이름_중복_실패() {
        assertThatThrownBy(() ->
                validateDuplicateName(new String[]{"jae", "hun", "jae"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.");
    }

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
