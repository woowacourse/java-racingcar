package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void testString1split2() {
        String data1and2 = "1,2";
        String[] splited = data1and2.split(",");
        assertThat(splited).contains("1","2");
    }

    @Test
    void testString1splitComma() {
        String data1andComma = "1,";
        String[] splited = data1andComma.split(",");
        assertThat(splited).containsExactly("1");
    }

    @Test
    void testDeleteBracket() {
        String data = "(1,2)";

        String afterData = data.substring(1, data.length() - 1);

        assertThat(afterData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자가 문자열의 인덱스를 벗어난 경우 예외발생 테스트")
    void testGetCharByIndex() {
        String testData = "abc";

        assertThatThrownBy(() -> {
                testData.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("문자열의 특정 위치의 문자를 가져오는 테스트")
    void testSpecificChar() {
        String data = "abc";

        char pickWord = data.charAt(0);

        assertThat(pickWord).isEqualTo('a');
    }
}
