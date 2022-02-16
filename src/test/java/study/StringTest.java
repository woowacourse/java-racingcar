package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void splitStringByCommaWithMultipleValues_Success() {
        String[] splitted = "1,2".split(",");
        assertThat(splitted).containsExactly("1", "2");
    }

    @Test
    void splitStringByCommaWithSingleValue_Success() {
        String[] splitted = "1".split(",");
        assertThat(splitted).contains("1");
    }

    @Test
    void subStringByParentheses_Success() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스로 특정 위치의 문자를 가져온다.")
    void getCharacterFromStringByIndex_Success() {
        // given
        String input = "abc";
        // when
        char result = input.charAt(1);
        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("인덱스로 특정 위치의 문자를 가져올 때 범위를 벗어나면 안된다.")
    void getCharacterFromStringByIndexWithOutbound_Fail() {
        // given
        String input = "abc";
        int index = 10;
        // then
        assertThatThrownBy(() -> input.charAt(index)).isInstanceOf(
                StringIndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("String index out of range: %d", index));
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(
                () -> input.charAt(index))
            .withMessageMatching("String index out of range: \\d+");
    }
}
