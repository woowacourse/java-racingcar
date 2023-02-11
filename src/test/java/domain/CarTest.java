package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    void checkTrim() {
        String input = "aa ";
        assertThat(new Car(input).getName()).isEqualTo("aa");
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdafg", "qwerfds", "", "    "})
    void checkLength(String input) {
        assertThatThrownBy(() ->
                new Car(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
