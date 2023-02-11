package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    @DisplayName("차 이름 앞 뒤의 공백이 제대로 지워지는지 확인한다")
    void checkTrim() {
        String input = " aa ";
        assertThat(new Car(input).getName()).isEqualTo("aa");
    }

    @DisplayName("차 이름이 길이에 맞지 않거나, 공백일때 IllegalArgumentException이 제대로 발생하는지 알아본다")
    @ParameterizedTest
    @ValueSource(strings = {"asdafg", "qwerfds", "", "    "})
    void checkLength(String input) {
        assertThatThrownBy(() ->
                new Car(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
