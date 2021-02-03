package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    void getCharacter(){
        int size;
        int index = 4;
        String abc = "abc";
        size = abc.length();
        assertThatThrownBy(() -> {
            try {
                "abc".charAt(index);
            } catch (Exception e) {
                throw new IndexOutOfBoundsException("Index: "+ index +", Size: " + size);
            }
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index: " + index + ", Size: " + size);
    }
}
