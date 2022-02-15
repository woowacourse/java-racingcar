package racingCar.controller.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingCar.controller.service.ValidateInputService.request;

import org.junit.jupiter.api.Test;
import racingCar.model.exception.NullInputException;

@SuppressWarnings("NonAsciiCharacters")
public class ValidateInputServiceTest {

    @Test
    void requestNames_null() {
        assertThatThrownBy(() -> request(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_빈문자열() {
        assertThatThrownBy(() -> request(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_그냥문자() {
        assertThat(request("hunch"))
                .isEqualTo("hunch");
    }

    @Test
    void requestNames_그냥숫자() {
        assertThat(request("5"))
                .isEqualTo("5");
    }
}