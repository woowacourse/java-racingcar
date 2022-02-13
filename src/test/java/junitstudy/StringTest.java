package junitstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class StringTest {

    @Test
    public void 구분자_테스트() {
        assertThat(split("1,2")).contains("1", "2");
    }

    @Test
    public void 숫자_한개_테스트() {
        assertThat(split("1")).containsExactly("1");
    }

    @Test
    public void 괄호_제거_테스트() {
        //given
        String input = "(1,2)";
        
        //when
        String result = input.substring(1, input.length()-1);
        
        //then
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("인덱스 범위 테스트")
    public void 특정_위치_문자_테스트() {
        assertThatThrownBy(()-> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }

    private String[] split(String input) {
        return input.split(",");
    }
}
