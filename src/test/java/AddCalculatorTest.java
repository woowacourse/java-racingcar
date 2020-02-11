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
    @Test
    @DisplayName("문자열이 들어오면 쉼표로 구분하여 배열로 변환한다.")
    void string_Split_Test() {
        String[] strArrays = Calculator.splitString("1,2");
        String[] expected = {"1","2"};
        Assertions.assertThat(strArrays).isEqualTo(expected);
    }
    @Test
    @DisplayName("문자열이 들어오면 : 로 구분하여 배열로 변환한다.")
    void stringSplitForColonTest() {
        String[] strArrays = Calculator.spliStirngForColon("1:2");
        String[] expected = {"1","2"};
        Assertions.assertThat(strArrays).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자를 추가하는 기능 테스트")
    void extractStringValue() {
        String delemeter = Calculator.addDelemeter("//;\n1;2;3");
        Assertions.assertThat(delemeter).isEqualTo("1;2;3");
    }
}
