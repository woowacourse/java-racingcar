package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest(name = "Car 이름 생성 테스트 name = {0}")
    @ValueSource(strings = {"pobi", "crong", "honux", "hi hi", "jj503"})
    void createCarNameTest(String name) {
        assertThatNoException().isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest(name = "Car 이름 생성 5자 초과 및 공백 예외 테스트 name = {0}")
    @ValueSource(strings = {"pobiiii", "abcdef", "", "  "})
    void createExceptionCarNameTest(String name) {
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
