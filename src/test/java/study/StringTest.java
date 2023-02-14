package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringTest {
    @Test
    @DisplayName("문자열 split 테스트(Delimiter : ,) ")
    void split_success() {
        String strWithDelimiter = "1,2";
        String strWithoutDelimiter = "1";

        String[] result1 = strWithDelimiter.split(",");
        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");
        assertThatThrownBy((() -> {
            assertThat(result1).containsExactly("2", "1");
        })).isInstanceOf(AssertionError.class);

        String[] result2 = strWithoutDelimiter.split(",");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
        assertThatThrownBy((() -> {
            assertThat(result2).containsExactly("2");
        })).isInstanceOf(AssertionError.class);
    }

    @Test
    @DisplayName("문자열 괄호 제거 테스트")
    void remove_parenthesis_success() {
        String str = "(1,2)";
        str = str.replaceAll("\\(|\\)", "");
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 것을 테스트")
    void getchar_at_specific_index_fail() {
        String str = "abc";
        int idx = 6;
        assertThatThrownBy(() -> {
            try {
                assertThat(str.charAt(idx)).isEqualTo('a');
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException(String.format("Index : %d, Size : %d", idx, str.length()));
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("Index : \\d+, Size : \\d+");
    }
}
