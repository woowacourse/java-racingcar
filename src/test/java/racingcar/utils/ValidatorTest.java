package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.utils.NumberConverter.*;
import static racingcar.utils.Validator.*;

@SuppressWarnings("NonAsciiCharacters")
public class ValidatorTest {

    @Test
    void 이름_빈칸_실패() {
        assertThatThrownBy(() ->
                validateBlank("jae ,hun,choi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 공백이 존재합니다.");
    }

    @Test
    void 이름_없음_실패() {
        assertThatThrownBy(() ->
                validateEachCarName(new String[]{"jae", ""}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 입력은 필수입니다.");
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
                validateEachCarName(new String[]{"jae", "hun", "jae"}))
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
                checkPositiveNumber(-3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 1 이상이어야 합니다.");
    }

}
