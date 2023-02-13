package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @DisplayName("문자열이 ',' 기준으로 split 되는지 확인한다.")
    @Test
    void divideStringTest() {
        String input = "1,2";

        assertThat(input.split(","))
                .contains("1", "2");
    }

    @DisplayName("split할 수 없는 문자열인 경우, 해당 문자열만을 포함한 배열로 반환하는지 확인한다.")
    @Test
    void divideStringToSingleArrayTest() {
        String input = "1";

        assertThat(input.split(","))
                .containsExactly("1");
    }

    @DisplayName("특정 문자열을 제거한 상태의 문자열을 반환한다.")
    @Test
    void replaceStringTest() {
        String input = "(1,2)";

        assertThat(input.replaceAll("[()]", ""))
                .isEqualTo("1,2");
    }

    @DisplayName("인덱스를 벗어난 값의 문자를 가져올 때 예외가 발생하는지 확인한다.")
    @Test
    void outOfBoundWhenCharAtStringTest() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
