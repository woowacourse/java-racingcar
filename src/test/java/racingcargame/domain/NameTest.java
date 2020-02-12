package racingcargame.domain;

import org.junit.jupiter.api.Test;

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
        })
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 쉼표만_입력되었을_때() {
        assertThatThrownBy(() -> {
            new Name("");
        })
                .isInstanceOf(RuntimeException.class);
    }

}
