package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 자동차_이름이_중복되었을_때() {
        assertThatThrownBy(() -> {
            new Name("pobi");
            new Name("pobi");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차_이름의_길이가_5를_초과할때() {
        assertThatThrownBy(() -> {
            new Name("123456789");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 쉼표만_입력되었을_때() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 같은_이름인지_확인() {
        Name name = new Name("brown");
        boolean result = name.equals("brown");
        assertThat(result).isTrue();
    }

    @Test
    void NULL이_들어왔을_때() {
        assertThatThrownBy(() -> {
            Name name = new Name(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
