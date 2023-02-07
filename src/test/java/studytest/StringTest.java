package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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
    @Test
    void 괄호를_포함한_문자열에서_괄호제거() {
        String input = "(1,2)";
        String result = input.replaceAll("[()]", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치_문자를_반환_테스트")
    void 특정위치_문자를_반환(){
        String input = "abc";
        Integer index = 1;
        Character result = input.charAt(index);
        assertThat(result).isEqualTo('b');
    }
}
