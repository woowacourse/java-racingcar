package racingcarTest;

import org.junit.jupiter.api.Test;
import racingcar.util.Validation;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void carNamesInput_overLengthLimit_throwException() {
        assertThatThrownBy(() -> Validation.carNameValidation("aaaaaaa,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNamesInput_hasBlankName_throwException() {
        assertThatThrownBy(() -> Validation.carNameValidation(",,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryNumInput_isNotDigit_throwException() {
        assertThatThrownBy(() -> Validation.tryNumValidation("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryNumInput_isNotNaturalNumber_throwException() {
        assertThatThrownBy(() -> Validation.tryNumValidation("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryNumInput_isRightDigit() {
        Validation.tryNumValidation("5");
    }
}
