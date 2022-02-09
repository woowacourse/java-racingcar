package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitByComma() {
        String input = "1,2";
        String[] splitResult = input.split(",");

        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
        assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    void splitByCommaWithoutComma() {
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void substringRemoveParenthesis() {
        String input = "(1,2)";
        String substringResult = input.substring(1,4);

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
}
