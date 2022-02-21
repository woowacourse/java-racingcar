package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    Application application = new Application();


   @Test
    void 공백_입력_예외_처리() {
        int number = Application.runCalculator(null);
        assertThat(number).isEqualTo(0);

        number = application.runCalculator("");
        assertThat(number).isEqualTo(0);

        number = application.runCalculator(" ");
        assertThat(number).isEqualTo(0);
    }


    @Test
    void 구분자_기준_연산() {
        int number = application.runCalculator("1,2");
        assertThat(number).isEqualTo(3);

        number = application.runCalculator("1:2");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void 숫자_하나_입력_처리() {
        int number = Application.runCalculator("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    void 커스컴_구분자_기준_연산() {
        int number = application.runCalculator("//;\n12;2;3");
        assertThat(number).isEqualTo(17);
    }

    @Test
    void 음수_입력_예외_처리() {
        assertThatThrownBy(() -> application.runCalculator("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_입력_예외_처리() {
        assertThatThrownBy(() -> application.runCalculator("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}