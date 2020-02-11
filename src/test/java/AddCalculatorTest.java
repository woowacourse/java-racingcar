import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {
    @Test
    @DisplayName("덧셈 기능만 테스트")
    void addTest() {
        int result = Calculator.calculation(2, 3);
        Assertions.assertThat(result).isEqualTo(5);
    }

}
