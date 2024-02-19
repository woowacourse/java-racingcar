package racingcar.dto.request;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCountRequestTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "100"})
    void toInt를_이용해서_int로_변환_성공(String input) {
        //when
        final RaceCountRequest raceCountRequest = new RaceCountRequest(input);
        final int count = raceCountRequest.toInt();

        final int expected = Integer.parseInt(input);

        //then
        assertThat(count).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {"  ", "0", "-1", "101", "!@#"})
    void toInt를_이용해서_int로_변환_실패(String input) {
        //when & then
        RaceCountRequest raceCountRequest = new RaceCountRequest(input);
        assertThatThrownBy(raceCountRequest::toInt)
                .isInstanceOf(InvalidInputException.class);
    }
}