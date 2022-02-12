package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormulaStringSplitterTest {

    @Test
    @DisplayName("기본 구분자로만 분리하는 경우")
    void basicSplit() {
        List<String> expectedResult = Arrays.asList("1", "2", "3");
        assertThat(FormulaStringSplitter.split("1,2:3")).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자만 사용하여 분리하는 경우")
    void onlyCustomDelimiter() {
        List<String> expectedResult = Arrays.asList("1", "2", "3");
        assertThat(FormulaStringSplitter.split(";", "1;2;3")).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 혼합해서 사용하는 경우")
    void mixDelimiter() {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4");
        assertThat(FormulaStringSplitter.split(";", "1;2:3,4")).isEqualTo(expectedResult);
    }
}