package junitstudy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void 구분자_테스트() {
        assertThat(split("1,2")).contains("1", "2");
    }

    @Test
    public void 숫자_한개_테스트() {
        assertThat(split("1")).containsExactly("1");
    }

    private String[] split(String input) {
        return input.split(",");
    }

}
