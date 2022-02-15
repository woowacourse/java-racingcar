package racingCar.controller.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingCar.controller.service.RequestService.requestCount;
import static racingCar.controller.service.RequestService.requestNames;

import org.junit.jupiter.api.Test;
import racingCar.model.exception.NullInputException;

@SuppressWarnings("NonAsciiCharacters")
public class RequestServiceTest {

    @Test
    void requestNames_null() {
        assertThatThrownBy(() -> requestNames(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_빈문자열() {
        assertThatThrownBy(() -> requestNames(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_그냥문자() {
        assertThat(requestNames("hunch"))
                .isEqualTo("hunch");
    }

    @Test
    void requestCount_null() {
        assertThatThrownBy(() -> requestCount(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestCount_빈문자열() {
        assertThatThrownBy(() -> requestCount(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_그냥숫자() {
        assertThat(requestCount("5"))
                .isEqualTo(5);
    }
}