package calculator.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class SplitByDelimiterToNumbersGeneratorTest {
    @Test
    void 커스텀_구분자_없는_경우() {
        assertThat(SplitByDelimiterToNumbersGenerator.split("11:3,4")).contains("11", "3", "4");
    }

    @Test
    void 커스텀_구분자_있는_경우() {
        assertThat(SplitByDelimiterToNumbersGenerator.split("//;\\n1;2:3")).contains("1", "2", "3");
    }
}