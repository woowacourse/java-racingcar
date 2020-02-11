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
}
