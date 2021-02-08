package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test split and substring for studying JUnit and AssertJ")
public class StringTest {

    @DisplayName("Test for split")
    @Test
    public void splitTest() {
        String[] overTwoValues = "1,2".split(",");
        assertThat(overTwoValues).containsExactly("1", "2");

        String[] singleValue = "1".split(",");
        assertThat(singleValue).containsExactly("1");
    }

    @DisplayName("Test for substring")
    @Test
    public void substringAndSplitTest() {
        String value = "(1,2)".substring(1, 4);
        String[] values = value.split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @DisplayName("Test for StringIndexOutOfBoundException")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    public void getChar(int index) {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(index))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
