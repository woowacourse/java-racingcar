package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void split_comma_delimiter_test1() {
        String string = "1,2";
        assertThat(string.split(",")).containsExactly("1", "2");
    }

    @Test
    void split_comma_delimiter_test2() {
        String string="1";
        assertThat(string.split(",")).containsExactly("1");
    }
    
    @Test
    void remove_bracket_in_string() {
        String string = "(1,2)";
        String changedString=string.substring(1, string.length()-1);

        assertThat(changedString).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"0,a", "1,b","2,c"})
    void get_character_of_index(int index, char expected) {
        String from = "abc";
        assertThat(from.charAt(index)).isEqualTo(expected);
    }

    @DisplayName("OutOfBoundsException 예외 테스트")
    @Test
    void out_of_bounds_exception_test() {
        int index=5;
        String from = "abc";

        assertThatThrownBy(()->from.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
