package stringadder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AdderTest {
    private Adder adder = new Adder();

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = adder.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 아무것도_안들어갔을_떄() throws Exception {
        int result = adder.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,3',4", "'1,3,6',10"})
    public void 숫자를_2개이상_입력(String s, int result) throws Exception {
        assertThat(adder.splitAndSum(s)).isEqualTo(result);
    }

    @Test
    public void 문자_split() {
        String[] result;
        result = adder.split("1,2:3");

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    public void 커스텀문자_split() {
        String[] result = adder.splitWhenCustom("1;2;3", ";");
        assertThat(result).containsExactly("1", "2", "3");

        result = adder.splitWhenCustom("1-2-3", "-");
        assertThat(result).containsExactly("1", "2", "3");

        result = adder.splitWhenCustom("-1--2-3", "-");
        assertThat(result).containsExactly("-1", "-2", "3");

//        result = adder.splitWhenCustom("-2-3", "-");
//        assertThat(result).containsExactly("-2", "3");
    }

    @Test
    public void 커스텀문자와_숫자_나누기() {
        List<String> result;
        result = Arrays.asList(adder.customMarkAndNumber("//;\n1;2;3"));
        assertThat(result).containsExactly(";", "1;2;3");

        result = Arrays.asList(adder.customMarkAndNumber("//-\n-1-2-3"));
        assertThat(result).containsExactly("-", "-1-2-3");
    }

    @Test
    public void 커스텀문자_계산() {
        int result;
        result = adder.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

        result = adder.splitAndSum("//-\n1-2-3");
        assertThat(result).isEqualTo(6);

        assertThatThrownBy(() -> adder.splitAndSum("//-\n-1-2-3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ValidateNumber.ERROR_MESSAGE_NEGATIVE_NUMBER);
    }

    @Test
    public void 예외처리_notCustom() {
        String[] input = new String[]{"-1", "2", "3"};
        assertThatThrownBy(() -> ValidateNumber.validate(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ValidateNumber.ERROR_MESSAGE_NEGATIVE_NUMBER);
    }

    @Test
    public void 숫자가아니문자예외처리() {
        String[] input = new String[]{"a", "2", "3"};
        assertThatThrownBy(() -> ValidateNumber.validate(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ValidateNumber.ERROR_MESSAGE_NOT_INTEGER);
    }

    @Test
    public void streamReduceTest() {
        List<Integer> finalNums = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(finalNums.stream().reduce((x, y) -> x + y).get());
    }
}
