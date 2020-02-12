package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterTest {
    @Test
    void defineDelimiter() {
        //given
        String input = "1,2:3";
        //then
        assertThat(new Delimiter(input).getDelimiter()).isEqualTo(Delimiter.DEFAULT_DELIMITER);

        //given
        String customDelimiter = "a";
        String customInput = "//" + customDelimiter +"\n1a2a3a";
        //then
        assertThat(new Delimiter(customInput).getDelimiter()).isEqualTo(customDelimiter);
    }

    @Test
    void hasCustomDelimiterTest() {
        //given
        String input = "//,\n";
        //then
        assertThat(new Delimiter(input).hasCustomDelimiter(input)).isTrue();
    }
}