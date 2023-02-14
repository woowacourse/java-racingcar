
package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1, 2"})
    @DisplayName(", 로 문자열이 나눠지는 경우를 테스트한다")
    void checkStringSplitByComma(String input) {
        //given
        //when
        String[] result = input.replace(" ", "")
            .split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("원소가 하나 뿐인 문자열에서 , 로 구분이 되는 경우를 테스트한다")
    void createInputWithNoDelimiter() {
        //given
        //when
        String[] result = splitStringByDelimiter("1");

        //then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열의 시작, 종료 괄호 제거를 테스트한다")
    void checkInputBracketDeletion() {
        //given
        String input = "(1,2)";
        char startBracket = '(';
        char endBracket = ')';

        int lastIndex = input.length() - 1;
        String result = "1,2";

        //when
        if (input.charAt(0) == startBracket && input.charAt(lastIndex) == endBracket) {
            input = input.substring(1, lastIndex);
        }

        //then
        assertThat(input).isEqualTo(result);
    }

    @Test
    @DisplayName("문자열의 특정 인덱스의 문자를 가져올 때, 그 인덱스가 문자열 인덱스의 범위를 벗어날 경우")
    void checkSpecificIndexFailure() {
        //given
        String input = "abc";

        //when
        //then
        assertThatThrownBy(() -> input.charAt(input.length())).isInstanceOf(
            StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("문자열의 특정 인덱스의 문자를 가져오는 경우")
    public void checkSpecificIndexSuccess() {
        //given
        String input = "abc";
        int index = 1;

        //when
        char result = input.charAt(index);

        //then
        assertThat(result).isEqualTo('b');
    }

    private String[] splitStringByDelimiter(String input) {
        String delimiter = ",";
        return input.split(delimiter);
    }

}
