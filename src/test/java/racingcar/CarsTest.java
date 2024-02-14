package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", ","})
    void exceptionInvalidInput(String given) {
        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Cars(given));
    }

}