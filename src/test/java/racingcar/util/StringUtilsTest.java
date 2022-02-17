package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName("구분자로 문자열 자르기")
    void splitByDelimiter() {
        // given
        String str = "a,b,c,d";
        String delimiter = ",";

        // when
        String[] arr = StringUtils.splitByDelimiter(str, delimiter);

        // then
        assertThat(arr.length).isEqualTo(4);
    }

    @Test
    @DisplayName("배열의 각 요소 strip 처리")
    void stripStringArray() {
        // given
        String[] arr = {"  test  "};
        String expectStr = "test";

        // when
        String[] stripArr = StringUtils.stripStringArray(arr);

        // then
        assertThat(stripArr[0]).isEqualTo(expectStr);
    }

}