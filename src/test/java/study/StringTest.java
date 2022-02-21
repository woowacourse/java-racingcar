package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 구분자_없음() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void 구분자_있음() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 괄호_제거() {
        String input = "(1,2)";
        String result = input.replaceAll("[\\(\\)]", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자를 가져오는 String 클래스의 메서드에 대한 정상 동작")
    void 특정위치_문자_가져오기() {
        int index = 1;
        String input = "abc";
        char character = input.charAt(index);
        assertThat(character).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치 문자를 가져올 때 위치 값이 벗어난 경우에 오류 발생")
    void 문자열_인덱스_범위_벗어남() {
        int index = 100;
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
