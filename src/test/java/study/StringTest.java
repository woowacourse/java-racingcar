package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    public static final String DELIMITER = ",";

    @DisplayName("스플릿 메소드 학습테스트")
    @Test
    void split() {
        String[] values = "1,2".split(DELIMITER);
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");
    }

    @DisplayName("substring 메소드 학습테스트")
    @Test
    void substring() {
        String value = "(1,2)".substring(1,4);
        assertThat(value).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드 학습테스트")
    @Test
    void charAtTest(){
        char value = "abc".charAt(0);
        assertThat(value).isEqualTo('a');
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
