package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void checkTrim() {
        String input = "aa ";
        assertThat(new Car(input).getCarName()).isEqualTo("aa");
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdafg", "qwerfds", "", "    "})
    void checkLength(String input) {
        assertThatThrownBy(() ->
                new Car(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}