import static org.assertj.core.api.Assertions.assertThat;

public class Test {

    @org.junit.jupiter.api.Test
    void 덧셈() {
        String input = "1,2:3,4";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(10);
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

        String customDelimiterInput = "//_`n11_222_3333";
        String[] splitedInput = Calculator.split(customDelimiterInput);
        assertThat(splitedInput).isEqualTo(new String[]{"11", "222", "3333"});
    }
}
