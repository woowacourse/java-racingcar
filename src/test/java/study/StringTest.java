package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String을 split 했을 때 ,를 기준으로 잘 분리된다.")
    void 문자열_분리_검증_테스트() {
        // given
        String sample1 = "1,2";
        String sample2 = "1";

        // when
        String[] split1 = sample1.split(",");
        String[] split2 = sample2.split(",");

        // then
        Assertions.assertThat(split1.length)
                .isEqualTo(2);

        Assertions.assertThat(split2.length)
                .isEqualTo(1);

        Assertions.assertThat(split1)
                .containsExactly("1", "2");

        Assertions.assertThat(split2)
                .containsExactly("1");
    }

    @Test
    @DisplayName("()가 포함된 string에서 ()를 제거한 스트링을 리턴한다.")
    void 문자열_제거_검증_테스트() {
        // given
        String sample = "(1,2)";

        // when
        String answer = sample
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");

        // then
        Assertions.assertThat(answer).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String에서 특정 문자의 위치를 가져온다.")
    void 문자열_특정_문자_위치_조회_테스트() {
        // given
        String sample = "abc";

        // when
        char first = sample.charAt(0);
        char second = sample.charAt(1);
        char third = sample.charAt(2);

        // then
        Assertions.assertThat(first)
                .isEqualTo('a');

        Assertions.assertThat(second)
                .isEqualTo('b');

        Assertions.assertThat(third)
                .isEqualTo('c');
    }

    @Test
    @DisplayName("String에서 특정 위치의 문자를 가져오지 못하는 경우")
    void 문자열_특정_위치_조회_예외() {
        // given
        String sample = "abc";

        // when & then
        Assertions.assertThatThrownBy(() -> sample.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
