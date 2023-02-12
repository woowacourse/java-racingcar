package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("2개 이상의 숫자를 콤마를 기준으로 split한다.")
    public void multipleSplitTest() {
        String text = "1,2";
        String[] result = text.split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("1개의 숫자를 콤마로 기준으로 split한다.")
    public void singleSplitTest() {
        String text = "1";
        String[] result = text.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("replace를 사용해 괄호를 제거한다.")
    public void replaceBracketTest() {
        String text = "(1,2)";
        String result = text.replace("(", "").replace(")", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 사용해 특정 위치의 문자를 가져온다.")
    public void charAtTest() {
        String text = "abc";
        Character result = text.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("chatAt을 사용할 때 사이즈를 넘어가는 인덱스를 호출할 때 예외가 발생한다.")
    public void chatAtExceptionTest() {
        String text = "abc";
        assertThatThrownBy(() -> text.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
