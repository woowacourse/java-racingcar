import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    void stringSplitTest() {
        String word = "1,2";

        String[] split = word.split(",");

        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void stringSplitExactlyTest() {
        String word = "1";

        String[] split = word.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("특정 문자를 제거한다")
    void stringReplaceTest() {
        String word = "(1,2)";

        String replaced = word.replaceAll("[()]", "");

        assertThat(replaced).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 찾는다")
    @ParameterizedTest
    @CsvSource({"0,a","1,b","2,c"})
    void stringFindByIndex(int index, char letter) {
        String word = "abc";

        char findLetter = word.charAt(index);

        assertThat(letter).isEqualTo(findLetter);
    }

    @Test
    @DisplayName("문자열의 범위를 벗어나면 예외 발생")
    void stringFindByIndexEx() {
        String word = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    word.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
