package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class StringSplitterTest {

    @Test
    void substring_인덱스_에러_예외_발생() {
        String input = "//1,2";
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열_나누기() {
        String input = "55:341,8";
        String[] numbers = StringSplitter.split(input);
        assertThat(numbers).isEqualTo(new String[]{"55", "341", "8"});
    }

    @Test
    void 기본_구분자_지정() {
        String basicDelimiterInput = "12:3,4";
        String[] numbers = StringSplitter.split(basicDelimiterInput);
        assertThat(numbers).isEqualTo(new String[]{"12", "3", "4"});
    }

    @Test
    void 커스텀_구분자_지정() {
        String customDelimiterInput = "//_\n11_222_3333";
        String[] numbers = StringSplitter.split(customDelimiterInput);
        assertThat(numbers).isEqualTo(new String[]{"11", "222", "3333"});
    }
}
