package racingcar.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

class RaceParticipantsRequestTest {
    private MovingStrategy mockMovingStrategy;

    @BeforeEach
    void setUp() {
        mockMovingStrategy = new MockMovingStrategy();
    }

    @Test
    void toRaceParticipants를_이용해서_RaceParticipants로_변환_성공() {
        //given
        final List<String> carNames = List.of("a", "bb", "ccc");
        final String inputNames = String.join(",", carNames);

        //when
        final RaceParticipants raceParticipants = new RaceParticipantsRequest(inputNames)
                .toRaceParticipants(mockMovingStrategy);
        final List<String> expectedCarNames = raceParticipants.getCars().stream()
                .map(Car::getName)
                .toList();

        //then
        assertThat(carNames).isEqualTo(expectedCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", ",일", "일,,이", "일,이,"})
    void toRaceParticipants를_이용해서_RaceParticipants로_변환_실패(final String name) {
        //when
        final RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(() -> raceParticipantsRequest.toRaceParticipants(mockMovingStrategy))
                .isInstanceOf(InvalidInputException.class);
    }
}