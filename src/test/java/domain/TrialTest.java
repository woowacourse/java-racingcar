package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TrialTest {
    @ParameterizedTest
    @ValueSource(strings = {"3ge", "~45", "2!9", "-98", "78.4"})
    void checkChar(String input) {
        assertThatThrownBy(() ->
                new Car(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkZero() {
        assertThatThrownBy(() ->
                new Trial("0")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkExtreme() {
        assertThatThrownBy(() ->
                new Trial("356574687456352313457643244567")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}