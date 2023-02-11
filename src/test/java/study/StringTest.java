package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열 분리 테스트")
    public void splitString() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 내에서 특정 문자 삭제 테스트")
    public void deleteString() {
        assertThat("(1,2)".replaceAll("[(|)]", "")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 인덱스의 문자 찾기")
    public void pickStringByIndex() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열의 범위 벗어날 시 예가")
    public void pickStringOutOfRange() {
        assertThatThrownBy(() -> "abc".charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
