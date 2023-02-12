package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "여섯글자이상"})
    void validateCarNameTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CarName(input));

    }
}