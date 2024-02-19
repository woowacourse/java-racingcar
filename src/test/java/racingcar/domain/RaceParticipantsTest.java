package racingcar.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.exception.InvalidInputException;
import racingcar.mock.MockMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Nested
    class 우승자를_가려낸다 {
        @Test
        void 우승자가_한_명인_경우() {
            //given
            final Car car1 = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            final Car car2 = new Car("car2", new MockMovingStrategy(List.of(true, true, false)));
            final Car car3 = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            final RaceParticipants raceParticipants = new RaceParticipants(List.of(car1, car2, car3));
            for (int i = 0; i < 3; i++) {
                raceParticipants.move();
            }

            //when
            final List<String> raceWinners = raceParticipants.getRaceWinnerNames();

            //then
            assertThat(raceWinners).containsExactly(car1.getName());
        }

        @Test
        void 우승자가_여러_명인_경우() {
            //given
            Car car1 = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            Car car2 = new Car("car2", new MockMovingStrategy(List.of(true, true, true)));
            Car car3 = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            RaceParticipants raceParticipants = new RaceParticipants(List.of(car1, car2, car3));
            raceParticipants.move();
            raceParticipants.move();
            raceParticipants.move();

            //when
            final List<String> raceWinners = raceParticipants.getRaceWinnerNames();

            //then
            assertThat(raceWinners).containsExactlyElementsOf(List.of(car1.getName(), car2.getName()));
        }
    }
}