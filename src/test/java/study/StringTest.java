package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class StringTest {
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    public void bracket() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    void bracketRemove() {
        String value = "(1,2)";
        value = value.replaceAll("[()]", "");
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 has")
    public void charGetFromString1() {
        String name = "Fortune";
        int index = 10;

        assertThatThrownBy(() -> {
            name.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 with")
    public void charGetFromString2() {
        String name = "Fortune";
        int index = 10;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    name.charAt(index);
                }).withMessageContaining("%d", index);
    }
}
