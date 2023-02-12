package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void splitTest1() {
        String data = "1,2";
        String[] afterData = data.split(",");
        assertThat(afterData).contains("1","2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void splitTest2() {
        String data = "1";
        String[] afterData = data.split(",");
        assertThat(afterData).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 replaceAll을 통해 ()을 제거하고 1,2를 반환하도록 테스트")
    void testDeleteBracket() {
        String data = "(1,2)";

        String afterData = data.replaceAll("[()]","");

        assertThat(afterData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자가 문자열의 인덱스를 벗어난 경우 예외발생 테스트")
    void testGetCharByIndex() {
        String data = "abc";

        assertThatThrownBy(() -> {
                data.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @DisplayName("문자열의 특정 위치의 문자를 가져오는 테스트")
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void testSpecificChar(int index, char pickedWord) {
        String data = "abc";
        assertThat(data.charAt(index)).isEqualTo(pickedWord);
    }
}
