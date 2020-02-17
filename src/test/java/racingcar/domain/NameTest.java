package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 공백이_입력되었을_경우() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백이 입력되었습니다.");
    }

    @Test
    void 이름이_6자_이상_입력되었을_경우() {
        assertThatThrownBy(() -> new Name("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이내로 작성해주세요.");
    }
}
