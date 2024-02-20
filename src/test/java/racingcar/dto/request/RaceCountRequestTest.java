package racingcar.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidInputException;

class RaceCountRequestTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "50", "100"})
    void 숫자로_변환에_성공한다(String input) {
        //when
        final RaceCountRequest raceCountRequest = new RaceCountRequest(input);
        final int count = raceCountRequest.toInt();

        final int expected = Integer.parseInt(input);

        //then
        assertThat(count).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {"  ", "0", "-1", "101", "1000", "!@#"})
    void 숫자로_변환에_실패한다(String input) {
        //when & then
        final RaceCountRequest raceCountRequest = new RaceCountRequest(input);
        assertThatThrownBy(raceCountRequest::toInt)
                .isInstanceOf(InvalidInputException.class);
    }
}
