package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("차량의 이름은 1~5자 이내로 입력 가능하고, 그렇지 않다면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "ronaldo"})
    void nameLengthTest(String name) {
        assertThatThrownBy(
            () -> new Name(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}