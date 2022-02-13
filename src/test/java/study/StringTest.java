package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 분리된다.")
    @Test
    void split_RegexContainComma_SplitText() {
        // given
        final String text = "1,2";
        final String regex = ",";

        // when
        String[] numbers = text.split(regex);

        // then
        assertThat(numbers).contains("1", "2");
    }

    @DisplayName("1을 ,로 split 했을 때 1을 포함하는 배열이 반환된다.")
    @Test
    void split_RegexContainComma_ReturnArray() {
        // given
        final String text = "1,";
        final String regex = ",";

        // when
        String[] numbers = text.split(regex);

        // then
        assertThat(numbers).containsExactly("1");
    }

    @DisplayName("(1,2)값이 주어졌을 때 substring으로 괄호를 제거하면 1,2가 반환된다.")
    @Test
    void substring_BeginIndexAndEndIndex_DeleteBracket() {
        // given
        final String text = "(1,2)";
        final int beginIndex = 1;
        final int endIndex = 4;

        // when
        String substring = text.substring(beginIndex, endIndex);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져율 때 위치 값을 벗어나면 StringIndexOutOfBoundsException을 발생 시킨다.")
    @Test
    void charAt_IndexGraterThanLength_ExceptionThrown() {
        // given
        final String text = "abc";
        final int index = 3;

        // when & then
        assertThatThrownBy(() -> {
            text.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
