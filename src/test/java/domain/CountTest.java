package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void countFailTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> new Count(value));
    }
}