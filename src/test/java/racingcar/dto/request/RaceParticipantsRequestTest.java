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
import racingcar.domain.move.MovingStrategy;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

class RaceParticipantsRequestTest {
    private MovingStrategy mockMovingStrategy;

    @BeforeEach
    void setUp() {
        mockMovingStrategy = new MockMovingStrategy();
    }

    @Test
    void 경주_참여자들로_변환에_성공한다() {
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
    void 경주_참여자들로_변환에_실패한다(final String name) {
        //when
        final RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(() -> raceParticipantsRequest.toRaceParticipants(mockMovingStrategy))
                .isInstanceOf(InvalidInputException.class);
    }
}
