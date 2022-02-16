package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - 1과 2가 분리되는지 테스트")
    void splitTextContainsComma() {
        String text = "1,2";
        assertThat(text.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 = 쉼표(,)가 없을 때 배열로 반환되는지 테스트")
    void splitTextWithoutComma() {
        String text = "1";
        assertThat(text.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 = 괄호가 포함된 문자열이 주어졌을때, 괄호 제거되는지 테스트")
    void deleteBrackets() {
        String text = "(1,2)";
        assertThat(text.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 = abc값이 주여졌을 때, 특정 위치의 문자를 가져오기")
    void getSingleChar() {
        String text = "abc";
        assertThat(String.valueOf(text.charAt(2))).isEqualTo("c");
    }

    @Test
    @DisplayName("요구사항3 = abc값이 주여졌을 때, 범위를 벗어난 경우")
    void outOfIndexString() {
        String text = "abc";

        assertThatThrownBy(() -> String.valueOf(text.charAt(3)))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> String.valueOf(text.charAt(3)))
                .withMessageMatching("String index out of range: \\d+");
    }

}
