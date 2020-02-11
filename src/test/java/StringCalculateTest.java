import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculateTest {
    @Test
    void removeHead() {
        DelimiterAndTale delimiterAndTale1 = new DelimiterAndTale(";", "1;2;3");
        assertThat(StringCalculate.removeHead("//;\n1;2;3")).isEqualTo(delimiterAndTale1);

        DelimiterAndTale delimiterAndTale2 = new DelimiterAndTale("[,:]", "1:2,3");
        assertThat(StringCalculate.removeHead("1:2,3")).isEqualTo(delimiterAndTale2);
    }
}
