package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @DisplayName("split 메서드는 특정 정규표현식을 기준으로 문자열을 배열로 구분한다.")
    @Test
    void splitByComma() {
        String input = "1,2";
        String[] splitResult = input.split(",");

        assertThat(splitResult).contains("1")
                .contains("2")
                .containsExactly("1", "2");
    }

    @DisplayName("split 메서드는 특정 정규표현식이 문자열에 없더라도 예외가 발생하지 않는다.")
    @Test
    void splitByComma_noExceptionOnNoComma() {
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @DisplayName("split 메서드는 구분자 두 개 사이에 문자열에 없는 경우 빈문자열로 간주한다.")
    @Test
    void splitByComma_continuousSeparatorsMeansEmpty() {
        String input = "1,,2";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1", "", "2")
                .hasSize(3);
    }

    @DisplayName("substring 메서드는 문자열로부터 특정 범위를 추출한다.")
    @Test
    void substring_extractRange() {
        String input = "(1,2)";
        String substringResult = input.substring(1, 4);

        assertThat(substringResult).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드는 문자열의 특정 위치에 있는 문자를 추출한다.")
    @Test
    void charAt_getsCharByIndex() {
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
    void charAt_throwExceptionOnOutOfBounds() {
        String input = "abc";
        String exceptionMessage = "String index out of range: 3";

        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(exceptionMessage);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching(exceptionMessage);
    }
}
