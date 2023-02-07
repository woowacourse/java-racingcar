package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void 값이_2개_이상인_문자열_분리() {
        String input = "1,2";
        String result[] = input.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 값이_하나인_문자열_분리() {
        String input = "1";
        String result[] = input.split(",");

        assertThat(result).containsExactly("1");
    }
}