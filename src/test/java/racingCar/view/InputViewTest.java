package racingCar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingCar.view.InputView.validate;

import org.junit.jupiter.api.Test;
import racingCar.exception.NullInputException;

@SuppressWarnings("NonAsciiCharacters")
public class InputViewTest {
    @Test
    void getNames_null() {

        assertThatThrownBy(() -> validate(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void getNames_빈문자열() {
        assertThatThrownBy(() -> validate(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void validate_그냥문자() {
        assertThat(validate("hunch"))
                .isEqualTo("hunch");
    }

    @Test
    void validate_그냥숫자() {
        assertThat(validate("5"))
                .isEqualTo("5");
    }
}