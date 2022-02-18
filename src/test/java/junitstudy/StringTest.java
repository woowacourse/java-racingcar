package junitstudy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("구분자 있을때")
    public void split_구분자_있을때() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("구분자 없을때")
    public void split_구분자_없을때() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("length 소괄호 제거")
    public void subString_length_소괄호_제거() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("index 소괄호 제거")
    public void subString_index_소괄호_제거() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(") + 1, input.lastIndexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 특정 위치 문자 반환")
    public void charAt_특정위치_문자_반환() {
        String input = "abc";
        String result = String.valueOf(input.charAt(0));
        assertThat(result).isEqualTo("a");
    }

    @Test
    @DisplayName("subString 특정 위치 문자 반환")
    public void subString_특정위치_문자_반환() {
        String input = "abc";
        int index = 1;
        String result = input.substring(index, index + 1);
        assertThat(result).isEqualTo("b");
    }

    @Test
    @DisplayName("IndexOutOfBoundsException 발생")
    public void indexOutOfBoundsException_발생() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            String input = "abc";
            int errorIndex = 5;
            String result = String.valueOf(input.charAt(errorIndex));
        });
    }

    @Test
    @DisplayName("Exception Message 검사")
    public void exception_message_검사() {
        assertThatIOException().isThrownBy(() -> {
            throw new IOException("exception message test");
        }).withMessage("exception message test");
    }
}
