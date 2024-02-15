package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.move.MovingStrategy;
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
        RaceParticipantsRequest raceParticipantsRequest = new RaceParticipantsRequest(name);

        //then
        assertThatThrownBy(() -> raceParticipantsRequest.toRaceParticipants(mockMovingStrategy))
                .isInstanceOf(InvalidInputException.class);
    }

    @Nested
    class 우승자를_가려낸다 {
        @Test
        void 우승자가_한_명인_경우() {
            //given
            Car car1 = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            Car car2 = new Car("car2", new MockMovingStrategy(List.of(true, true, false)));
            Car car3 = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            RaceParticipants raceParticipants = new RaceParticipants(List.of(car1, car2, car3));
            for (int i = 0; i < 3; i++) {
                raceParticipants.move();
            }

            //when
            List<Car> raceWinners = raceParticipants.getRaceWinners();

            //then
            assertThat(raceWinners).hasSize(1).isEqualTo(List.of(car1));
        }

        @Test
        void 우승자가_여러_명인_경우() {
            //given
            Car car1 = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            Car car2 = new Car("car2", new MockMovingStrategy(List.of(true, true, true)));
            Car car3 = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            RaceParticipants raceParticipants = new RaceParticipants(List.of(car1, car2, car3));
            for (int i = 0; i < 3; i++) {
                raceParticipants.move();
            }

            //when
            List<Car> raceWinners = raceParticipants.getRaceWinners();

            //then
            assertThat(raceWinners).hasSize(2).isEqualTo(List.of(car1, car2));
        }
    }
}