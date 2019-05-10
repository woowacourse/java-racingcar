package textCalculaotr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.soap.Text;

import static org.assertj.core.api.Assertions.assertThat;

public class TextCalculatorTest {
    TextCalculator textCalculator;

    @BeforeEach
    void setUp() {
        textCalculator = new TextCalculator();
    }

    @Test
    void 사칙연산_처리_에러() {
        String[] inputText = {"1"};
        Assertions.assertThrows(NullPointerException.class, () -> {
            textCalculator.execute(inputText);
        }, "에러");
    }

    @Test
    void 사칙연산_처리_결과1() {
        String[] inputText = {"1", "+", "2"};
        int result = textCalculator.execute(inputText);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사칙연산_처리_결과2() {
        String[] inputText = {"1", "+", "2", "*", "3"};
        int result = textCalculator.execute(inputText);
        assertThat(result).isEqualTo(9);
    }
}
