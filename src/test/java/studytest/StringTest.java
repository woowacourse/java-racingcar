package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 입력을_분리한다() {
        String input = "1,2";
        String[] splitResult = input.split(",");
        assertThat(splitResult).contains("1", "2");
    }

    @Test
    void 숫자_한개_입력시_한개반환(){
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }
}
