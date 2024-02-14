package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바사아자"})
    void CarNameTest1(String name) {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백이나 스페이스를 사용하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void CarNameTest2(String name) {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 null을 입력하면 예외가 발생한다.")
    @Test
    void CarNameTest3() {
        assertThatThrownBy(() -> Name.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 앞 뒤에 공백이 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" pobi", "pobi "})
    void CarNameTest4(String name) {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}