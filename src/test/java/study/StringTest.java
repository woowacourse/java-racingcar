package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1")
    public void stringSplitTest1() {
        String testString1 = "1,2";
        String[] split = testString1.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1-2")
    public void stringSplitTest2() {
        String testString2 = "1,";
        String[] split = testString2.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    public void removeParenthesisTest() {
        String testString = "(1,2)";
        String substring = testString.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1: 특정 위치 문자 추출 테스트")
    public void getValueByIndexTest() {
        String testString = "123";
        char expected = testString.charAt(0);
        assertThat(expected).isEqualTo('1');
    }

    @Test
    @DisplayName("요구사항3-2: 경계값 예외 테스트")
    public void tryOutOfBoundExceptionTest() {
        String testString = "123";
        Integer outOfIndex = 5;
        assertThatThrownBy(() -> {
            testString.charAt(outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
