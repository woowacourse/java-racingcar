package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 문자열_테스트() {
        String s = "abc,def";
        String[] split = s.split(",");
        assertThat(split).contains("abc", "def");
    }
}
