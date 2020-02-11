import static org.assertj.core.api.Assertions.assertThat;

public class Test {

    @org.junit.jupiter.api.Test
    void 덧셈() {
        String input = "1,2,3,4";
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }
}
