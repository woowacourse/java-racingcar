import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    void plusTest() {
        assertThat(Calculate.plus("1,2")).isEqualTo(3);
        assertThat(Calculate.plus("1,2,3")).isEqualTo(6);
        assertThat(Calculate.plus("1,2:3")).isEqualTo(6);
    }

    @Test
    void customPlusTest() {
        assertThat(Calculate.plus("//;\n1;2;3")).isEqualTo(6);
    }
}
