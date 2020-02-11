package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalTest {
    @Test
    void 빈문자열_널_체크() {
        int result = Cal.calculate(null);
        assertThat(result).isEqualTo(0);

        result = Cal.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자하나입력시() {
        int result = Cal.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 덧셈_테스트() {
        int result = Cal.calculate("1,2:3:4,5");
        assertThat(result).isEqualTo(1+2+3+4+5);
    }

    @Test
    void 커스텀_구분자(){
        int result = Cal.calculate("//;\n1;2;4;5");
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 커스텀_구분자_에러(){
        assertThatThrownBy(() -> {
            Cal.calculate("//@\n1;2;4;5");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_음수_및_숫자이외(){
        assertThatThrownBy(() -> {
            Cal.calculate("//;\n-1;2");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 디폴트_음수_및_숫자이외(){
        assertThatThrownBy(() -> {
            Cal.calculate("-1:2");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            Cal.calculate("a:2");
        }).isInstanceOf(RuntimeException.class);
    }
}
