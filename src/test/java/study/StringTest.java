package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("둘 이상의 숫자가 포함된 문자열 분리")
    public void stringSplit1() {
        String input = "1,2";

        String[] result = input.split(",");
        String[] expected = new String[]{"1", "2"};

        for (String s: result) {
            assertThat(expected).contains(s);
        }
    }

    @Test
    @DisplayName("길이가 1인 문자열 분리")
    public void stringSplit2() {
        String input = "1";
        String expected = "1";

        String[] result = input.split(",");

        assertThat(result).contains(expected);
    }

    @Test
    @DisplayName("양쪽 괄호가 존재하는 경우, 괄호 제거")
    public void removeParenthesesSuccess() {
        String input = "(1,2)";
        String expected = "1,2";

        String result = input.replace("(", "")
                .replace(")", "");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 인덱스에 위치한 문자 가져오기")
    public void getCharacterByIndexSuccess() {
        String input = "abc";
        int index = 0;

        char result = input.charAt(index);

        assertThat(result).isEqualTo('a');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("인덱스가 범위를 벗어나면 예외 발생")
    public void getCharacterByIndexFail(int index) {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
