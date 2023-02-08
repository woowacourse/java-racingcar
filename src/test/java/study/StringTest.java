package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메소드₩ - 숫자 두 개 입력")
    void splitTestWithTwoNumbers() {
        String target = "1,2";
        assertThat(target.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 메소드 - 숫자 하나 입력")
    void splitTestOneNumber() {
        String target = "1";
        assertThat(target.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("replace 메소드 - 괄호 제거")
    void replaceTestWithParentheses() {
        String target = "(1,2)";
        String real = target.replaceAll("[()]", "");
        assertThat(real).isEqualTo("1,2");
    }

    @Test
    @DisplayName("indexOf 메소드 - 특정 문자 위치 반환")
    void indexOfTestToGetIndex() {
        String target = "abc";
        assertThat(target.indexOf("b")).isEqualTo(1);
    }

}
