package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void 콤마를_기준으로_잘_분리되는지_테스트() {
        String target = "1,2";
        String delimiter = ",";

        String[] expected = new String[]{"1", "2"};

        assertThat(target.split(delimiter)).containsExactly(expected);
    }

    @Test
    public void 콤마를_기준으로_분리했을때_콤마가_없다면_그대로_반환하는지_테스트() {
        String target = "1";
        String delimiter = ",";

        String[] expected = new String[]{"1"};

        assertThat(target.split(delimiter)).containsExactly(expected);
    }

    @Test
    public void 문자열_양끝_괄호제거_테스트() {
        String target = "(1,2)";
        int startIndex = target.indexOf("(") + 1;
        int endIndex = target.indexOf(")");

        String expected = "1,2";

        assertThat(target.substring(startIndex, endIndex)).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정위치의_문자를_잘_가져오는지_테스트")
    public void 특정위치의_문자를_잘_가져오는지_테스트() {
        String target = "abc";

        assertThat(target.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("위치_값을_벗어나면_예외를_반환하는지_테스트")
    public void 위치_값을_벗어나면_예외를_반환하는지_테스트() {
        String target = "abc";

        assertThatThrownBy(() -> target.charAt(target.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
