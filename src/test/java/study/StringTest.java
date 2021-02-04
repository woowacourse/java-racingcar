package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String values = "(1,2)".substring(1, 4);
        assertThat(values).isEqualTo("1,2");
    }

    @DisplayName("Proper_charAt_Test")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAtProper(int testIndex, char testCharacter) {
        String values = "abc";
        assertThat(values.charAt(testIndex)).isEqualTo(testCharacter);
    }

    @DisplayName("Exceptional_charAt_Test")
    @Test
    void charAtException() {
        assertThatThrownBy(() -> {
            try {
                char values = "abc".charAt(3);
            } catch(Exception e) {
                throw new IndexOutOfBoundsException("Index: 3, Size: 3");
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }

    @DisplayName("Exceptional_charAt_Test")
    @ParameterizedTest
    @ValueSource(ints = {3,4,-1})
    void charAtException2(int testIndex) {
        String values = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
            try {
                char value = values.charAt(testIndex);
            } catch(Exception e) {
                throw new IndexOutOfBoundsException("Index: " + testIndex + ", Size: " + values.length());
            }
        }).withMessageMatching("Index: (-?[0-9]*), Size: \\d+");
    }

}