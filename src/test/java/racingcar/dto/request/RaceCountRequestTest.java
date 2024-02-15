package racingcar.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidInputException;

class RaceCountRequestTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "50", "100"})
    void toInt를_이용해서_int로_변환_성공(String input) {
        //when
        RaceCountRequest raceCountRequest = new RaceCountRequest(input);
        int count = raceCountRequest.toInt();

        int expected = Integer.parseInt(input);

        //then
        assertThat(count).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "101", "1000", "!@#"})
    void toInt를_이용해서_int로_변환_실패(String input) {
        //when & then
        assertThatThrownBy(() -> new RaceCountRequest(input).toInt())
                .isInstanceOf(InvalidInputException.class);
    }
}