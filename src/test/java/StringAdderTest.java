import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringAdder.StringAdder;

public class StringAdderTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2;3", "3:4;7"}, delimiter = ';')
    void 덧셈(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {";0"}, delimiter = ';')
    void 빈값이나_null이_들어오는_테스트(String value, int expected) {
        int result = StringAdder.add(value);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;1", "3;3"}, delimiter = ';')
    void 숫자_1개만_들어오는_경우(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3,4:5;15", "1,3:5:10;19"}, delimiter = ';')
    void 숫자가_2개이상인_경우(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:-3,4:5", "1,3:5:-1"})
    void 숫자가_음수인_경우(String strings) {
        Assertions.assertThatThrownBy(() -> StringAdder.add(strings))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("음수는 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:A,4:5", "z,3:5:1"})
    void 숫자_이외의_값이_들어온_경우(String strings) {
        Assertions.assertThatThrownBy(() -> StringAdder.add(strings))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("숫자 이외의 값은 입력하실 수 없습니다.");
    }

    @Test
    void 커스텀구분자_사용했을_경우_최소조건() {
        int result = StringAdder.add("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }
    @Test
    void 커스텀구분자만_들어올_경우_최소조건() {
        int result = StringAdder.add("//;\n");
        Assertions.assertThat(result).isEqualTo(0);
    }
}