import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName(",를 기준으로 split한다.")
    void splitByCommaTest() {
        String input = "1,2";
        String[] arr = input.split(",");
        assertThat(arr).contains("1", "2");
        assertThat(arr).containsExactly("1", "2");

        String input2 = "1";
        String[] arr2 = input2.split(",");
        assertThat(arr2).contains("1");
        assertThat(arr2).containsExactly("1");
    }

}