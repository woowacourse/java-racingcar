package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Name name = new Name("abcde");
        Name other = new Name("abcde");

        assertThat(name).isEqualTo(other);
    }

    @DisplayName("이름은 공백이 될 수 없다.")
    @Test
    void checkNameNonEmpty() {
        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 길이 제한은 5자 이하이다.")
    @Test
    void checkNameLength() {
        assertThatThrownBy(() -> new Name("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
