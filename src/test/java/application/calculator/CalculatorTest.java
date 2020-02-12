package application.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @Test
    void testSum(){
        String[] inputs = {"1","2","3"};
        assertThat(calculate.sumTokens(inputs)).isEqualTo(6);
    }

    @Test
    void 음수일경우_RuntimeException_발생() {
        assertThatThrownBy(() ->  {
            calculate.calculateStringEquation("-1,2,1");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void Null_Or_빈문자열_일경우_0을_반환한다() {
        assertThat(calculate.checkNullOrEmptyOrInteger(null)).isEqualTo(0);
        assertThat(calculate.checkNullOrEmptyOrInteger("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자만 입력될 경우 입력된 숫자를 반환한다.")
    void inputOnlyIntegerTest() {
        assertThat(calculate.calculateStringEquation("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("기본 구문자일때 올바른 값을 반환한다")
    void 기본구문자일때_올바른_값을_반환한다() {
        assertThat(calculate.calculateStringEquation("1,2,3")).isEqualTo(6);
        assertThat(calculate.calculateStringEquation("1:2:3")).isEqualTo(6);
        assertThat(calculate.calculateStringEquation("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구문자일때 올바른 값을 반환한다")
    void 커스텀_구문자일때_올바른_값을_반환한다() {
        assertThat(calculate.calculateStringEquation("//;\n1;2;3")).isEqualTo(6);
    }
}