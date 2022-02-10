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
}