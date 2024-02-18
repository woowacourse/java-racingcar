package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "banana"})
    @DisplayName("이름이 공백이거나 5글자를 초과하면 예외가 발생한다.")
    void invalidName(String input) {
        assertThrows(IllegalArgumentException.class, () -> new CarName(input));
    }

    @Test
    @DisplayName("이름을 생성할 수 있다.")
    void validNameTest() {
        String input = "pobi";
        Assertions.assertDoesNotThrow(() -> new CarName(input));
    }
}
