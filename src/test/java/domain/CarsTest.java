package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi,pobi"})
    @DisplayName("자동차의 수가 1보다 작거나, 중복되는 이름을 가지면 예외가 발생한다.")
    void duplicateCarNamesTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }
}