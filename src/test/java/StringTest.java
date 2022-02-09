import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void splitTest() {
        String[] split = "1,3".split(",");
        Assertions.assertThat(split).contains("1", "3");
        Assertions.assertThat(split).containsExactly("1", "3");
    }

    @Test
    void substringTest() {
        String split = "(1,2)".substring(1, 4);
        Assertions.assertThat(split).isEqualTo("1,2");
    }
}
