package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차_이름의_길이가_5를_초과할때() {
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 공백만_입력되었을_때() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 같은_이름인지_확인() {
        Name name = new Name("brown");
        boolean result = name.equals("brown");
        assertThat(result).isTrue();
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 다른_이름인지_확인() {
        Name name = new Name("brown");
        boolean result = name.equals("pobi");
        assertThat(result).isFalse();
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void NULL이_들어왔을_때() {
        assertThatThrownBy(() -> {
            Name name = new Name(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
