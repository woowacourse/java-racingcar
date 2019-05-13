package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumericExpressionTest {

    @Test
    void 허용된특수문자외특수문자가들어간식() {
        String input = "3 + 2 : 3";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 숫자가아닌문자가들어간식() {
        String input = "3 + 2 / ㅁ";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 연산자로끝나는식() {
        String input = "3 + 2 /";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 빈문자열() {
        String input = "";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 공백() {
        String input = " ";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 숫자연산자혼합인지확인() {
        String[] array = "3 + 2 * 4".split(" ");
        //assertThat(InputHandler.canCalculate(array)).isEqualTo(true);
    }




}
