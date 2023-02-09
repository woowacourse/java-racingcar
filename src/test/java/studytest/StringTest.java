package studytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    @DisplayName("입력 분리 테스트")
    void 입력을_분리한다() {
        String input = "1,2";
        String[] splitResult = input.split(",");
        assertThat(splitResult).contains("1", "2");
    }

    @Test
    @DisplayName("숫자 한개 입력시 한개 반환 테스트")
    void 숫자_한개_입력시_한개반환() {
        String input = "1";
        String[] splitResult = input.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @Test
    @DisplayName("괄호를 포함한 문자열에서 괄호 제거 테스트")
    void 괄호를_포함한_문자열에서_괄호제거() {
        String input = "(1,2)";
        String result = input.replaceAll("[()]", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치_문자를_반환_테스트")
    void 특정위치_문자를_반환() {
        String input = "abc";
        Integer index = 1;
        Character result = input.charAt(index);
        assertThat(result).isEqualTo('b');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("범위 외에 접근시 예외가 발생한다")
    void 범위_외에_접근시_예외_발생(int provided) {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(provided))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
