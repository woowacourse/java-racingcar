import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Test {

    @org.junit.jupiter.api.Test
    void 덧셈() {
        String input = "1,2:3,4";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }

    @org.junit.jupiter.api.Test
    void substring_인덱스_에러_예외_발() {
        String input = "//1,2";
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @org.junit.jupiter.api.Test
    void 문자열_나누기() {
        String input = "55:341,8";
        String[] splitedInput = Calculator.split(input);
        assertThat(splitedInput).isEqualTo(new String[]{"55", "341", "8"});
    }

    @org.junit.jupiter.api.Test
    void 커스텀_구분자_지정() {
        String noneCustomDelimiterInput = "12:3,4";
        String[] splitedInput2 = Calculator.split(noneCustomDelimiterInput);
        assertThat(splitedInput2).isEqualTo(new String[]{"12", "3", "4"});

        String customDelimiterInput = "//_\n11_222_3333";
        String[] splitedInput = Calculator.split(customDelimiterInput);
        assertThat(splitedInput).isEqualTo(new String[]{"11", "222", "3333"});
    }

    @org.junit.jupiter.api.Test
    void 숫자_이외의값_혹은_음수_입력() {
        String exceptNumberInputs = "ㅋㅋ:-222,3333";
        assertThatThrownBy(() -> {
            Calculator.calculate(exceptNumberInputs);
        }).isInstanceOf(RuntimeException.class);
    }

    @org.junit.jupiter.api.Test
    void 숫자만_들어왔을때() {
        String input = "123";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(123);
    }
}
