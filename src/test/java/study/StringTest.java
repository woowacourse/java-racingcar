package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    private static final String testString = "1,2";

    @Test
    @DisplayName("요구사항 1")
    public void testSplit() {
        String[] splitedString = testString.split(",");
        assertThat(splitedString).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    public void subString() {
        assertThat("(1,2)".replaceAll("[()]", "")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    public void charAt() {

        // 정상
        assertThat("abc".charAt(1)).isEqualTo('b');

        // 예외
        assertThatThrownBy(()->{
            //  발생된 예외
            // index out of array
            // 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분
            "abc".charAt(5);
//            Character.compare("abc".charAt(1),'a');
        }).isInstanceOf(IndexOutOfBoundsException.class);
        //assertThatThrownBy("abc".charAt(1)).isEqualTo('b');
    }
}
