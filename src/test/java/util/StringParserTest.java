package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 가공 기능 테스트")
public class StringParserTest {

    @DisplayName("지정해준 구분자를 바탕으로 문자열을 쪼갤 수 있다")
    @Test
    void testSplit() {
        String target = "리비,에버,테니,잉크,제리";
        List<String> split = StringParser.split(target, ",");
        assertThat(split).containsExactly("리비", "에버", "테니", "잉크", "제리");
    }

    @DisplayName("숫자로 이루어진 문자열인 경우 숫자로 파싱할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void testParseToInteger(String target) {
        int actual = StringParser.parseToInt(target);
        int expected = Integer.parseInt(target);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자열을 숫자로 파싱하려는 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"리비", "잉크", "에버", "제리", "테니"})
    void testParseInvalidStringToInteger(String target) {
        assertThatThrownBy(() -> StringParser.parseToInt(target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열에 공백이 들어간 경우 앞뒤 공백을 제거한다.")
    @Test
    void testBlank() {
        String target = "리비   ,에버,      테니,잉크,제리";
        List<String> split = StringParser.split(target, ",");
        assertThat(split).containsExactly("리비", "에버", "테니", "잉크", "제리");
    }
}
