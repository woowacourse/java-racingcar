package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"hoon", "ji", "choi"})
    @DisplayName("자동차 이름 객체 생성 기능")
    public void create_valid_name(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"rookie", " ", ""})
    @DisplayName("자동차 이름 객체 생성 예외처리 기능")
    public void create_invalid_name(String name) {
        assertThatThrownBy(() -> new Name(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
