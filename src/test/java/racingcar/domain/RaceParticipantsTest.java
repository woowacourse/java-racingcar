package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceParticipantsTest {
    private MovingStrategy mockMovingStrategy;

    @ParameterizedTest
    @ValueSource(strings = {"a,a", "a,b,b"})
    void 중복된_자동차_이름이_있을_경우_실패(String name) {
        //given
        mockMovingStrategy = new MockMovingStrategy();

        //when
        final RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(() -> raceParticipantsRequest.toRaceParticipants(mockMovingStrategy))
                .isInstanceOf(InvalidInputException.class);
    }
}