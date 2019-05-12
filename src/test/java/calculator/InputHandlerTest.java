package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputHandlerTest {

    @Test
    void 연산자가_혼합된_경우() {
        String[] array = "3 + 2 * 4".split(" ");
        assertThat(InputHandler.canCalculate(array)).isEqualTo(true);
    }

    @Test
    void 식이_연산자로_끝나는_경우() {
        String[] array = "3 + 2 *".split(" ");
        assertThat(InputHandler.canCalculate(array)).isEqualTo(false);
    }
}
