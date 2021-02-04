package stringCalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorControllerTest {
    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        this.calculatorController = new CalculatorController(null);
    }

    @DisplayName("정상적인 구분자인 경우 커스텀 구분자 얻기 성공")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=;", "//#\\n3#6#4=#", "//&\\n3&4&9=&"}, delimiter = '=')
    public void getCustomDelimiter_정상적인_구분자인_경우(String value, String expected) {
        String customDelimiter = calculatorController.getCustomDelimiter(value);

        assertThat(customDelimiter).isEqualTo(expected);
    }

    @DisplayName("정상적인 구분자가 아닌 경우 커스텀 구분자 얻기 실패")
    @ParameterizedTest
    @ValueSource(strings = {"//,\\n1,2,3=,", "//:\\n1,2,3=,"})
    public void getCustomDelimiter_정상적인_구분자가_아닌_경우(String value) {
        assertThatThrownBy(() -> {
            calculatorController.getCustomDelimiter(value);
        }).isInstanceOf(RuntimeException.class);
    }


}