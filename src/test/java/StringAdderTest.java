import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringAdder.StringAdder;

public class StringAdderTest {
    @Test
    void 덧셈() {
        int result = StringAdder.add("1,2");
        Assertions.assertThat(result).isEqualTo(3);
        StringAdder.add("1:2");
        Assertions.assertThat(result).isEqualTo(3);
    }
}