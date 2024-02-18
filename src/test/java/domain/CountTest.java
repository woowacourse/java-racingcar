package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    @Nested
    @DisplayName("객체 생성 테스트")
    class GenerationTest {
        @ParameterizedTest
        @ValueSource(ints = {5, 7})
        void success(int value) {
            assertDoesNotThrow(() -> new Count(value));
        }

        @ParameterizedTest
        @ValueSource(ints = {0,-1})
        void fail(int value) {
            assertThrows(IllegalArgumentException.class, () -> new Count(value));
        }
    }
}
