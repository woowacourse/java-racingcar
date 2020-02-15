package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void Name은_비어있는_문자열이면_예외발생() {
        String name = "";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Name은_null이면_예외발생() {
        String name = null;
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Name의_String은_name인지_확인() {
        String expected = "라테";
        String actual = new Name("라테").toString();
        assertThat(actual).isEqualTo(expected);
    }
}
