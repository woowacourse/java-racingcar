package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름이 10자 이상인 경우 예외처리")
    void exceededMaxCarNameLengthException() {
        String name = "overtenletters";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("10자 이하");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는 경우 예외처리")
    void minimumCarNameLengthException() {
        String name = "";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }
}