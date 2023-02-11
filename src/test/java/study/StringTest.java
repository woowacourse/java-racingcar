package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void 요구사항1() {
        String str1 = "1,2";
        String str2 = "1";

        String[] result1 = str1.split(",");
        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");
        assertThatThrownBy((() -> {
            assertThat(result1).containsExactly("2", "1");
        })).isInstanceOf(AssertionError.class);

        String[] result2 = str2.split(",");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
        assertThatThrownBy((() -> {
            assertThat(result2).containsExactly("2");
        })).isInstanceOf(AssertionError.class);
    }

    @Test
    public void 요구사항2() {
        String str = "(1,2)";
        str = str.replaceAll("\\(|\\)", "");
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 것을 테스트")
    public void 요구사항3() {
        String str = "abc";
        int idx1 = 0, idx2 = 6;
        assertThat(str.charAt(idx1)).isEqualTo('a');
        assertThatThrownBy(() -> {
            try {
                assertThat(str.charAt(idx2)).isEqualTo('a');
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException(String.format("Index : %d, Size : %d", idx2, str.length()));
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("Index : \\d+, Size : \\d+");
    }
}
