package racingcar.dto.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.exception.InvalidInputException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceParticipantsRequestTest {
    @Test
    void toRaceParticipants를_이용해서_RaceParticipants로_변환_성공() {
        //given
        List<String> carNames = List.of("a", "bb", "ccc");
        String inputNames= String.join( ",", carNames);

        //when
        RaceParticipants raceParticipants = new RaceParticipantsRequest(inputNames).toRaceParticipants();
        List<String> expectedCarNames = raceParticipants.getCars().stream().map(Car::getName).toList();

        //then
        assertThat(carNames).isEqualTo(expectedCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",일", "일,,이", "일,이,"})
    void toRaceParticipants를_이용해서_RaceParticipants로_변환_실패(String name) {
        //when
        RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(raceParticipantsRequest::toRaceParticipants)
                .isInstanceOf(InvalidInputException.class);
    }
}