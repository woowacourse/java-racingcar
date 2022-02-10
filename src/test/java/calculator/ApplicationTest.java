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
}