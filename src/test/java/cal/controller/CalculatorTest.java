package cal.controller;

import cal.domain.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorTest {
    private StringCalculator stringCalculator;

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
        assertThat(stringCalculator.minus(6, 2)).isEqualTo(4);
    }

    @AfterEach
    void tearDown() {
        stringCalculator = null;
        System.out.println("tearDown");
    }
}
