package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumericExpressionTest {

    @Test
    void 허용된_특수문자_외_특수문자가_들어간_식() {
        String input = "3 + 2 : 3";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 숫자가_아닌_문자가_들어간_식() {
        String input = "3 + 2 / ㅁ";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 연산자로_끝나는_식() {
        String input = "3 + 2 /";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();
    }

    @Test
    void 빈_문자열() {
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
    void 숫자_사이의_여러_개_공백() {
        String input = "3 +  2";
        assertThrows(Exception.class, () -> {
            new NumericExpression(input);
        }).printStackTrace();

    }




}
