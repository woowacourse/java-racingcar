package cal.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;


    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();

        System.out.println("SetUp");
    }

    @Test
    void 덧셈() {
        assertThat(stringCalculator.add(1, 2)).isEqualTo(3);
        System.out.println("덧셈");
    }

    @Test
    void 뺼셈() {
        System.out.println("뺄셈");
        assertThat(stringCalculator.minus(6, 2)).isEqualTo(3);
    }

    @Test
    void 곱하기() {
        assertThat(stringCalculator.multiple(4, 5)).isEqualTo(20);
    }

    @Test
    void 나누기() {
        assertThat(stringCalculator.divide(10, 2)).isEqualTo(5);
    }

    @Test
    void 계산() {
        String[] strings = "2 + 3 * 4 / 2".split(" ");
        assertThat(stringCalculator.calculate(strings)).isEqualTo(10);
        System.out.println("10");
    }

    @Test
     void 연산자하나() {
        String[] strings = "2 + 3".split(" ");
        assertThat(stringCalculator.calculate(strings)).isEqualTo(5);
        System.out.println("+");
    }

    @Test
    void 연산자둘() {
        String[] strings = "2 - 3 + 7".split(" ");
        assertThat(stringCalculator.calculate(strings)).isEqualTo(6);
    }



    @AfterEach
    void tearDown() {
        stringCalculator = null;
        System.out.println("tearDown");
    }
}
