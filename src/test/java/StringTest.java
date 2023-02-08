import static org.assertj.core.api.Assertions.assertThat;

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

}