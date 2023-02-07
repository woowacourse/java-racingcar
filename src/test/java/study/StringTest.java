package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2 로 구분할 때 잘 분리되는지 확인")
    void split() {
        String testCase1 = "1,2";
        String[] split1 = testCase1.split(",");

        String testCase2 = "1";
        String[] split2 = testCase2.split(",");

        assertThat(split1).contains("1", "2");
        assertThat(split2).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 자르기")
    void substring() {
        String testCase = "(1,2)";
        testCase = testCase.substring(1, 4);

        assertThat(testCase).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 확인하기")
    void checkException() {
        String testCase = "abc";
        int inOfBounds = 2;
        int outOfBounds = 3;

        assertThat(testCase.charAt(inOfBounds)).isEqualTo('c');
        assertThatThrownBy(() -> testCase.charAt(outOfBounds))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + testCase.length());
    }
}
