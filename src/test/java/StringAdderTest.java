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
    @Test
    void 빈값이나_null이_들어오는_테스트() {
        int result = StringAdder.add("");

        Assertions.assertThat(result).isEqualTo(0);
        result = StringAdder.add(null);
        Assertions.assertThat(result).isEqualTo(0);
    }
    @Test
    void 숫자_1개만_들어오는_경우() {
        int result = StringAdder.add("7");

        Assertions.assertThat(result).isEqualTo(7);
    }
}