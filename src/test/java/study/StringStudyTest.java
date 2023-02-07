package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringStudyTest {

    @Nested
    class split_테스트 {

        @Test
        void String_1과_2로_분리할_경우_테스트() {
            String input = "1,2";
            String[] splitedInput = input.split(",");

            assertThat(splitedInput).containsExactly("1", "2");
        }

        @Test
        void String_1로만_분리할_경우_테스트() {
            String input = "1";
            String[] splitedInput = input.split(",");

            assertThat(splitedInput).containsExactly("1");
        }
    }
}
