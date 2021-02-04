package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");
    }

    @Test
    void name() {
        String values = "(1,2)".substring(1,4);
        assertThat(values).isEqualTo("1,2");
    }

//    @Test
//    @DisplayName("요구사항3")
//    void name3() {
//        String value = String.valueOf("abc".charAt(1));
//        assertThatThrownBy(() -> {
//            throw new IndexOutOfBoundsException(value);
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("b");
//    }
//
//    @Test
//    void name4(){
//        assertThatThrownBy(() -> {
//            String value = String.valueOf("abc".charAt(7));
//            throw new IndexOutOfBoundsException(value);
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("b");
//    }

    @Test
    @DisplayName("요구사항3")
    void name3() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    void name4(){
        assertThatThrownBy(() -> {
            assertThat("abc".charAt(0)).isEqualTo('a'); // assert 안에 assert?
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }
}
