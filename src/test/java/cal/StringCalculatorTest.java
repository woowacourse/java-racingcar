package cal;

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
    void 계산() {
        String[] strings = "2 + 3 * 4 / 2".split(" ");
        assertThat(stringCalculator.calculate(strings)).isEqualTo(10);
        System.out.println("10");
    }

    @Test
     void 연산자하나() {
        String[] strings = "2 + 3".split(" ");
        assertThat(stringCalculator.calculate(strings)).isEqualTo(5);
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
