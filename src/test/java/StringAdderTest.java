import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringAdder.StringAdder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdderTest {
    @DisplayName("두 수의 덧셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2;3", "3:4;7"}, delimiter = ';')
    void 덧셈(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @DisplayName("빈 값이나 null이 들어오는 테스트")
    @ParameterizedTest
    @CsvSource(value = {";0"}, delimiter = ';')
    void 빈값이나_null이_들어오는_테스트(String value, int expected) {
        int result = StringAdder.add(value);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자가 1개만 들어오는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1;1", "3;3"}, delimiter = ';')
    void 숫자_1개만_들어오는_경우(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @DisplayName("2개 이상의 숫자가 들어오는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3,4:5;15", "1,3:5:10;19"}, delimiter = ';')
    void 숫자가_2개이상인_경우(String value, int expected) {
        Assertions.assertThat(StringAdder.add(value)).isEqualTo(expected);
    }

    @DisplayName("음수인 숫자가 들어오는 경우 테스")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:-3,4:5", "1,3:5:-1"})
    void 숫자가_음수인_경우(String strings) {
        Assertions.assertThatThrownBy(() -> StringAdder.add(strings))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("음수는 입력하실 수 없습니다.");
    }

    @DisplayName("숫자 이외의 값이 들어오는 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:A,4:5", "z,3:5:1"})
    void 숫자_이외의_값이_들어온_경우(String strings) {
        Assertions.assertThatThrownBy(() -> StringAdder.add(strings))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("숫자 이외의 값은 입력하실 수 없습니다.");
    }

    @DisplayName("커스텀 구분자를 사용했을 경우 테스트")
    @Test
    void 커스텀구분자_사용했을_경우_최소조건() {
        int result = StringAdder.add("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자만 사용했을 경우 테스트")
    @Test
    void 커스텀구분자만_들어올_경우_최소조건() {
        int result = StringAdder.add("//;\n");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_null_또는_빈문자() {
        int result = StringAdder.add(null);
        assertThat(result).isEqualTo(0);

        result = StringAdder.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
        int result = StringAdder.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        int result = StringAdder.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAdder.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        int result = StringAdder.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_negative() throws Exception {
        assertThatThrownBy(() -> StringAdder.add("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}