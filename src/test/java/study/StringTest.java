package study;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringTest {

    String targetStr1 = "1,2";
    String targetStr2 = "1";
    String targetStr3 = "(1,2)";
    String targetStr4 = "abc";

    public static String[] stringSplitter(String target) {
        return target.split(",");
    }

    public static String stringReplacer(String target) {
        return target.replace("(", "")
            .replace(")", "");
    }

    public static String stringSelector(String target, int index) {
        return target.substring(index, index+1);
    }

    @Test
    @DisplayName("1,2를 1과 2로 잘 분리시켜야 한다.")
    public void stringSplitterTest1() {
        Assertions.assertThat(stringSplitter(targetStr1))
            .contains("1", "2");
    }

    @Test
    @DisplayName("1만을 포함하는 배열을 반환한다.")
    public void stringSplitterTest2() {
        Assertions.assertThat(stringSplitter(targetStr2))
            .containsExactly("1");
    }

    @Test
    @DisplayName("괄호를 제거한 문자열을 반환한다.")
    public void stringReplacerTest1() {
        Assertions.assertThat(stringReplacer(targetStr3)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @MethodSource("stringSelectorTestSource")
    @DisplayName("인덱스에 맞는 문자를 반환한다.")
    public void stringSelectorTest(int index, String expected) {
        Assertions.assertThat(stringSelector(targetStr4, index)).isEqualTo(expected);
    }

    private static Stream<Arguments> stringSelectorTestSource() {
        return Stream.of(
            Arguments.of(0, "a"),
            Arguments.of(1, "b"),
            Arguments.of(2, "c")
        );
    }

    @Test
    @DisplayName("범위를 넘어간 인덱스를 입력 시 StringIndexOutOfBoundsException을 발생시킨다.")
    public void stringSelectorExceptionTest() {
        Assertions.assertThatThrownBy(() -> stringSelector(targetStr4, 4))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
