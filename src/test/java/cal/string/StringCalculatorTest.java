package cal.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    void setUp (){
        cal = new StringCalculator();
    }

    @Test
    void addTest() {
        assertThat(cal.calculate("1 + 15")).isEqualTo(16);
    }

    @Test
    void subTest() {
        assertThat(cal.calculate("24 - 11")).isEqualTo(13);
    }

    @Test
    void mulTest() {
        assertThat(cal.calculate("3 * 12")).isEqualTo(36);
    }

    @Test
    void divTest() {
        assertThat(cal.calculate("15 / 3")).isEqualTo(5);
    }

    @Test
    void generalTest() {
        assertThat(cal.calculate("2 + 3 * 4")).isEqualTo(20);
    }
}
