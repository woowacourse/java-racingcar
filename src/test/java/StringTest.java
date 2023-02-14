import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("요구사항 1: ,를 기준으로 split한다.")
    void splitByCommaTest() {
        containsTest("1,2", "1", "2");
        containsTest("1", "1");
    }

    private static void containsTest(String input, String... output) {
        String[] arr = splitByComma(input);
        assertThat(arr).contains(output);
        assertThat(arr).containsExactly(output);
    }

    private static String[] splitByComma(String input) {
        return input.split(",");
    }

    @Test
    void replaceBracketTest() {
        String input = "(1,2)";
        assertThat(input.replaceAll("[()]", "")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오고, 위치 값을 벗어나면 예외 처리한다.")
    void stringIndexTest() {
        String input = "abc";
        try {
            System.out.println(input.charAt(5));
        } catch (StringIndexOutOfBoundsException exception) {
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class).equals(exception);
        }
    }

}
