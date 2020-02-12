package calculator.domain;


import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    @Test
    void numbersTest() {
        //given
        String input = "1,2:3";
        String delimiter = ",|:";
        //then
        assertThat(new Numbers(input, delimiter)).isEqualTo(List.of(1,2,3));
    }

    @Test
    void validate() {
        //given
        final String isNotNumber = "-,3";
        final String delimiter = ",|:";
        //then
        assertThatThrownBy(() -> {
            new Numbers(isNotNumber, delimiter);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Input has something not number");

        //given
        final String hasNegativeNumber = "1,-2:3";
        //then
        assertThatThrownBy(() -> {
            new Numbers(hasNegativeNumber, delimiter);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Input has negative number");
    }
}