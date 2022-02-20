package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("String 클래스 split메서드 테스트")
    @Nested
    class SplitTest {
        @Test
        @DisplayName("배열 요소가 모두 포함되 있는지 검사한다.")
        void checkElements() {
            final String[] splitedNumber = splitString();

            assertThat(splitedNumber).contains("1", "2");
        }

        @Test
        @DisplayName("배열 요소의 순서가 맞는지 검사한다.")
        void checkArrangement() {
            final String[] splitedNumber = splitString();

            assertThat(splitedNumber).containsExactly("1", "2");
        }

        private String[] splitString() {
            final String numbers = "1,2";
            return numbers.split(",");
        }
    }

    @Test
    @DisplayName("스트링에서 괄호를 제거한 부분 문자열을 만든다")
    void removeBracket() {
        final String numbers = "(1,2)";
        final String numbersWithoutBracket = numbers.substring(1, numbers.length() - 1);
        assertThat(numbersWithoutBracket).isEqualTo("1,2");
    }

    @DisplayName("스트링에서 특정 위치의 문자를 가져올 때 ")
    @Nested
    class CharAtTest {
        @Test
        @DisplayName("정상적인 위치값을 주면 해당 위치의 문자를 가져온다.")
        void getCharacterFromString() {
            final String str = "abc";

            assertThat(str.charAt(1)).isEqualTo('b');
        }

        @Test
        @DisplayName("위치값을 벗어나면 OutOfException이 발생한다.")
        void testOutOfException() {
            final String str = "abc";

            assertThatThrownBy(() -> {
                str.charAt(10);
            }).isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
