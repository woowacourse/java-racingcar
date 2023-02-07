package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @DisplayName("1,2를 ,로 분리하기")
    @Test
    void test1() {
        String str = "1,2";
        String[] split = str.split(",");

        assertAll(
                () -> assertThat(split).contains("1", "2"),
                () -> assertThat(split).containsExactly("1", "2")
        );
    }

    @DisplayName("1을 ,로 분리했을때 1이 나오는지 확인")
    @Test
    void test2() {
        String str = "1";
        String[] split = str.split(",");

        assertAll(
                () -> assertThat(split).contains("1"),
                () -> assertThat(split).containsExactly("1")
        );
    }

    @DisplayName("(1,2)에서 괄호를 제거하고 1,2를 반환한다")
    @Test
    void test3() {
        String str = "(1,2)";
        str = str.replace("(", " ");
        str = str.replace(")", "");

        assertThat(str).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({
            "0,a",
            "1,b",
            "2,c",
            "3,m"
    })
    void test4(int index, char c) {
        String str = "abc";
        if (str.length() <= index) {
            assertThatThrownBy(() -> str.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
            return;
        }
        assertThat(str.charAt(index)).isEqualTo(c);
    }
}
