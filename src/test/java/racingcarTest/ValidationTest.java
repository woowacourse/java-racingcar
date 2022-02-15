package racingcarTest;

import org.junit.jupiter.api.Test;
import racingcar.controller.Validation;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void player_name_over_lengthLimit_throw_exception() {
        assertThatThrownBy(() -> Validation.carNameValidation("aaaaaaa,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void player_name_blank_throw_exception() {
        assertThatThrownBy(() -> Validation.carNameValidation(",,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void if_tryNum_is_string_throw_exception() {
        assertThatThrownBy(() -> Validation.tryNumValidation("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void if_tryNum_is_minus_throw_exception() {
        assertThatThrownBy(() -> Validation.tryNumValidation("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_tryNum_is_integer() {
        Validation.tryNumValidation("5");
    }
}
