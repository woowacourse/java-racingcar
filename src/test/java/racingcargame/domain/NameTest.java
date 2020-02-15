package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 자동차_이름은_비어있는_문자열이면_예외발생() {
        String name = "";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_null이면_예외발생() {
        String name = null;
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
