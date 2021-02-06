package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split이 잘 되는지 확인한다.")
    void split() {
        String[] values = "1,2".split(",");

        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String의 substring 메소드를 활용해 ()을 제거하고 1,2를 반환")
    void testNumberTwo() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 ??? 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현")
    void StringTestNumberThree() {
        String value = "abc";
        char b = value.charAt(1);

        assertThat(b).isEqualTo('b');
        assertThatThrownBy(() -> value.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
