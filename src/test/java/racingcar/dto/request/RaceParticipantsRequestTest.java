package racingcar.dto.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceParticipantsRequestTest {
    private MovingStrategy mockMovingStrategy;

    @BeforeEach
    void setUp() {
        mockMovingStrategy = new MockMovingStrategy();
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