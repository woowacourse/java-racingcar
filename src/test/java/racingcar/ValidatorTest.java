package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.Validator.*;

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
                validateCarCount(new String[]{"jae ", "hun", "ab", "cd", "ef", "gh"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 5대 이하이어야 합니다.");
    }

    @Test
    void 이름_길이_초과_실패() {
        assertThatThrownBy(() ->
                validateNameLength(new String[]{"jae ", "hunnnnnn", "jake"}))
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
}
