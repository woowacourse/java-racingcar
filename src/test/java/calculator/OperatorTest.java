package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    @Test
    void Operator에_속하지_않은_string() {
        assertThat(Operator.hasOperatorCode("&")).isEqualTo(false);
    }

    @Test
    void Operator에_속한_string() {
        assertThat(Operator.hasOperatorCode("+")).isEqualTo(true);
    }

    @Test
    void getOperatorByCode_정상동작() {
        assertThat(Operator.getOperatorByCode("+")).isEqualTo(Operator.PLUS);
    }

}
