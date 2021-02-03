package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1","2");
        assertThat(values).containsExactly("1","2");
    }

    @Test
    public void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    public void getStringByIndex() {
        char value = "abc".charAt(1);
        assertThat(value).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올때 위치값을 벗어나면 예외발생")
    public void throwsStringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        ;
    }
}
