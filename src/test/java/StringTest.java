import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName(",를 기준으로 split한다.")
    void splitByCommaTest() {
        String[] arr = splitByComma("1,2");
        assertThat(arr).contains("1", "2");
        assertThat(arr).containsExactly("1", "2");

        String[] arr2 = splitByComma("1");
        assertThat(arr2).contains("1");
        assertThat(arr2).containsExactly("1");
    }

    private static String[] splitByComma(String input) {
        return input.split(",");
    }

}