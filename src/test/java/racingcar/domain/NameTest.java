package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("이름이 1자 미만, 5자 초과일 경우")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"", "Wishoon", "123456"})
    void name_invalid_length(String invalidName) {
        assertThatThrownBy(() -> Name.from(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 1~5자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"is2js", "코니"})
    void name_valid_length(String name) {
        assertDoesNotThrow(() -> Name.from(name));
    }
}
