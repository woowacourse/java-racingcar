package study;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("split 메서드는 특정 정규표현식을 기준으로 문자열을 배열로 구분한다.")
    @Test
    void splitByComma() {
        String input = "1,2";
        String[] splitResult = input.split(",");

        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
        assertThat(splitResult).containsExactly("1", "2");
    }

    @DisplayName("split 메서드는 특정 정규표현식이 문자열에 없더라도 예외가 발생하지 않는다.")
    @Test
    void splitByCommaWithoutComma() {
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @DisplayName("substring 메서드는 문자열로부터 특정 범위를 추출한다.")
    @Test
    void substringRemoveParenthesis() {
        String input = "(1,2)";
        String substringResult = input.substring(1, 4);

        assertThat(substringResult).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드는 문자열의 특정 위치에 있는 문자를 추출한다.")
    @Test
    void charAtGetsCharByIndex() {
        String input = "abc";
        char charAtResult0 = input.charAt(0);
        char charAtResult1 = input.charAt(1);
        char charAtResult2 = input.charAt(2);

        assertThat(charAtResult0).isEqualTo('a');
        assertThat(charAtResult1).isEqualTo('b');
        assertThat(charAtResult2).isEqualTo('c');
    }

    @DisplayName("charAt 메서드는 문자열의 위치를 벗어나는 경우 IndexOutOfBounds 예외가 발생한다.")
    @Test
    void charAtThrowExceptionOnOutOfBounds() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
