package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void splitTest() {
        String str = "1,2";
        String[] result = str.split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitTest2() {
        String str2 = "1";
        String[] result2 = str2.split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void splitTest3() {
        String str3 = "(1,2)";
        String result3 = str3.substring(1, str3.length() - 1);

        assertThat(result3).isEqualTo("1,2");
    }

    @Test
    void splitTest4(){
        String str4 = "1:3:5";
        String[] result = str4.split(":");

        assertThat(result).contains("1","3","5");
    }

    @Test
    void splitTest5() {
        String str4 = "bunny";
        char c = str4.charAt(1);
        assertThat(c).isEqualTo('u');


    }


    @Test
    @DisplayName("예외 확인")
    void 예외를_확인한다(){
        // given some preconditions

        // when
        String str4 = "bunny";
        try {
            char c = str4.charAt(10);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).isInstanceOf(Exception.class);
        }
    }
}