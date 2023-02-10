package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("split 메소드를 이용해 문자열이 구분자,로 분할되는지 테스트한다.")
    @Test
    void 문자열_컴마로_나누기_테스트() {
        final String str = "1,2";
        String[] arr = str.split(",");

        assertThat(arr).containsExactly("1", "2");

        final String str2 = "1";
        String[] arr2 = str2.split(",");
        assertThat(arr2).containsExactly("1");
    }

    @DisplayName("String 클래스의 메소드를 이용해 ()가 제거되는지 테스트 한다.")
    @Test
    void 특정문자_제거하기_테스트() {
        final String str = "(1,2)";

        String result = str.replace("(", "")
                .replace(")", "");
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String 클래스의 메소드를 이용해 특정 위치의 문자 가져오기를 테스트한다.")
    @Test
    void 특정위치_문자_가져오기_테스트() {
        final String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @DisplayName("String에서 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 테스트한다.")
    @Test
    void 특정위치_문자_가져오기_범위_초과_예외테스트() {
        final String str = "abc";

        int index = str.length();
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
