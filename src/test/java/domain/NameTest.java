package domain;

import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @DisplayName("자동차 이름은 1자 이상, 5자 이하여야 한다.")
    @Test
    void test() {
        assertDoesNotThrow(() -> new Name("쥬"));
        assertDoesNotThrow(() -> new Name("쥬니"));
        assertDoesNotThrow(() -> new Name("쥬니헙크1"));


        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}