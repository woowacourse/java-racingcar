package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 이름_빈칸_실패() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 입력은 필수입니다.");
    }

    @Test
    void 이름_공백_포함() {
        assertThatThrownBy(() -> new Name("1 2 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 공백이 존재합니다.");
    }

    @Test
    void 이름_길이_초과() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하이어야 합니다.");
    }
}