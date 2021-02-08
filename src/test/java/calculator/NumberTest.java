package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("숫자 객체 생성")
    public void number_create() {
        Number number = new Number("3");
        assertThat(number.getNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("null 입력 시 0 반환")
    public void number_null_exception() {
        Number number = new Number(null);
        assertThat(number.getNumber()).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    public void number_empty_exception() {
        Number number = new Number("");
        assertThat(number.getNumber()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 이외의 값 입력 시 예외 처리")
    public void strange_value_exception() throws Exception {
        assertThatThrownBy(() -> new Number("d"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 입력 시 예외 처리")
    public void negative_number_exception() throws Exception {
        assertThatThrownBy(() -> new Number("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
