package junitstudy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void 구분자_테스트() {
        //given
        String input = "1,2";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1", "2");
    }

    @Test
    public void 숫자_한개_테스트() {
        //given
        String input = "1";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).containsExactly("1");
    }

}
