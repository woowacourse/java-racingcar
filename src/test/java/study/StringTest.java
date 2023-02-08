package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("split 작동 테스트")
    void splitTest() {
        String test = "1,2";
        String[] split = test.split(",");

        assertThat(split).contains("1")
                .contains("2");
    }

    @Test
    @DisplayName("\"1\"이 케이스로 주어졌을 때 ,로 split")
    void splitTest2() {
        String test = "1";
        String[] split = test.split(",");

        assertThat(split).containsExactly("1");
    }


    @Test
    @DisplayName("subString 사용 예제")
    void subStringTest() {
        String test = "(1,2)";
        String substring = test.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }
}
