package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringStudyTest {

    @Nested
    class split_테스트 {

        @Test
        void 1과_2로_분리할_경우_테스트() {
            String input = "1,2";
            String[] splitedInput = input.split(",");

            assertThat(splitedInput).containsExactly("1", "2");
        }

        @Test
        void 1로만_분리할_경우_테스트() {
            String input = "1";
            String[] splitedInput = input.split(",");

            assertThat(splitedInput).containsExactly("1");
        }

        @Test
        void 특정_문자_제거_테스트() {
            String input = "(1,2)";
            String replacedInput = input.replaceAll("[()]", "");

            assertThat(replacedInput).isEqualTo("1,2");
        }

        @Test
        void 특정_문자_위치_찾기_문자열로_특정_문자_찾기_테스트() {
            String input = "abc";

            assertThat(input.indexOf("a")).isEqualTo(0);
            assertThat(input.indexOf("b")).isEqualTo(1);
            assertThat(input.indexOf("c")).isEqualTo(2);
        }
    }
}
