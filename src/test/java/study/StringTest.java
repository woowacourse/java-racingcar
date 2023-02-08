package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    void splitArray12(){
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1","2");
    }

    @Test
    void splitOnly1(){
        String input = "1,";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void removeBrackets(){
        String input = "(1,2)";
        String result = input.substring(1,input.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void findSpecificElement(){
        String input = "abc";
        char result = input.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    void dd(){
        String input = "abc";

        assertThatThrownBy(() -> {input.charAt(3);}).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }
}
