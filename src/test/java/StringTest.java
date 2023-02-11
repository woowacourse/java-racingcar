import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {


    @DisplayName("문자열을 ,로 구분해서 분리한다.")
    @Test
    void split() {
        String input = "1,2";

        String[] numbers = input.split(",");

        assertThat(numbers).containsExactly("1", "2");
    }

    @DisplayName("양 끝에 괄호가 포함되어있는 문자열에서 괄호를 제거한다.")
    @Test
    void substring() {
        String input = "(1,2)";

        String number = input.substring(1, 4);

        assertThat(number).isEqualTo("1,2");
    }

    @DisplayName("abc라는 문자열에서 charAt으로 0번째 값을 가져오면 a이다.")
    @Test
    void charAt() {
        String input = "abc";

        char alphabet = input.charAt(0);

        assertThat(alphabet).isEqualTo('a');
    }

    @DisplayName("charAt에서 문자열의 위치 값을 벗어난 인덱스가 주어졌을 때 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAtException() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
