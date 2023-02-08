package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest(name = "이름이 5글자 이하인 경우(EX: [{arguments}]) 생성된다.")
    @ValueSource(strings = {
            "1", "12", "123", "1234", "12345"
    })
    void test1(final String name) {
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("이름이 5글자를 초과할 경우 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 없이 생성되는 경우 예외가 발생한다.")
    void test3() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}