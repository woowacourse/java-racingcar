package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.move.MovingStrategy;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

class RaceParticipantsTest {
    private MovingStrategy mockMovingStrategy;

    @BeforeEach
    void setUp() {
        mockMovingStrategy = new MockMovingStrategy();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,b", "a,b,c,b", "a,b,c,b,c"})
    void 중복된_자동차_이름이_있을_경우_실패(String name) {
        //when
        final RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(() -> raceParticipantsRequest.toRaceParticipants(mockMovingStrategy)).isInstanceOf(
                InvalidInputException.class);
    }

    @Test
    void 자동차들을_움직인다() {
        //given
        final Car move3times = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
        final Car move2times = new Car("car2", new MockMovingStrategy(List.of(true, true, false)));
        final Car move1times = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

        final RaceParticipants raceParticipants = new RaceParticipants(List.of(move3times, move2times, move1times));

        //when
        raceParticipants.move();
        raceParticipants.move();
        raceParticipants.move();

        //then
        assertSoftly(softly -> {
            final List<Car> cars = raceParticipants.getCars();
            softly.assertThat(cars.get(0).getPosition()).isEqualTo(3);
            softly.assertThat(cars.get(1).getPosition()).isEqualTo(2);
            softly.assertThat(cars.get(2).getPosition()).isEqualTo(1);
        });
    }
}
