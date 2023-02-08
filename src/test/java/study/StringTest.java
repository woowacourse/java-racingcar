package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("앞 뒤가 잘 쪼개지는지 테스트")
    void splitTest12() {
        String given = "1,2";
        String[] split = given.split(",");

        Assertions.assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("구분자가 없는 경우를 테스트")
    void splitTest1() {
        String given = "1";
        String[] split = given.split(",");

        Assertions.assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 추출 테스트")
    void substringTest() {
        String given = "(1,2)";
        String replaced = given.substring(1, 4);
        Assertions.assertThat(replaced).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드를 활용해 특정위치의 문자를 가져오는 테스트")
    void getSpecificCharacterByPosition() {
        String given = "abc";
        char result = given.charAt(0);
        Assertions.assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("범위를 넘어사는 위치의 문자를 가져오면 예외가 발생한습")
    void throwExceptionWhenIndexOutOfRange() {
        String given = "abc";
        Assertions.assertThatThrownBy(() -> given.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
