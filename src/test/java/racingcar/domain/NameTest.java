package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("이름 빈칸")
    @Test
    void nameValidation1() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 입력은 필수입니다.");
    }

    @DisplayName("이름 공백 포함")
    @Test
    void nameValidation2() {
        assertThatThrownBy(() -> new Name("1 2 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백이 존재합니다.");
    }

    @DisplayName("이름 허용 길이 초과")
    @Test
    void nameValidation3() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하이어야 합니다.");
    }
}