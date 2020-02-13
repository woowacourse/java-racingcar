package stringadder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AdderTest {
    private Adder adder = new Adder();

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = adder.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = adder.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = adder.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,3',4", "'1,3,6',10"})
    public void 숫자를_2개이상_입력(String s, int result) {
        assertThat(adder.splitAndSum(s)).isEqualTo(result);
    }

    @Test
    public void 문자_split() {
        List<Integer> result;
        result = adder.getSplit("1,2:3");

        assertThat(result).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"';','1;2;3'", "'-','1-2-3'"})
    public void 커스텀문자_split(String mark, String equation) {
        List<Integer> result;
        result = adder.getSplit(mark, equation);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    public void 커스텀문자_테스트() {
        List<String> result;
        result = Arrays.asList(adder.customMarkAndEquation("//;\n1;2;3"));

        assertThat(result).containsExactly(";", "1;2;3");
    }

    @Test
    public void 커스텀문자_계산() {
        int result;
        result = adder.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 음수입력시예외처리테스트() {
        assertThatThrownBy(() -> adder.validateNegativeNumber(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 문자입력예외처리() {
        assertThatThrownBy(() -> adder.getSplit("1,12,b"))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("커스텀문자가 - 일 때 계산 테스트")
    public void customNegative() {
        int result;
        result = adder.splitAndSum("//-\n1-2-3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"'//-\n-1-2-3'", "'//-\n1--2-3"})
    @DisplayName("커스텀문자가 - 일 때 예외처리테스트")
    public void customNegativeMinusErrorTest(String s) {
        assertThatThrownBy(() -> adder.splitAndSum(s));
    }

}