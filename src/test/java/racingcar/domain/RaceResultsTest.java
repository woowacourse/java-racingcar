package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.mock.MockMovingStrategy;

class RaceResultsTest {
    private RaceResults raceResults;

    @BeforeEach
    void setUp() {
        raceResults = new RaceResults();
    }

    @Test
    void 경기_결과를_기록하고_가져온다() {
        //given
        final Car move3times = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
        final Car move2times = new Car("car2", new MockMovingStrategy(List.of(true, true, false)));
        final Car move1times = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

        final RaceParticipants raceParticipants = new RaceParticipants(List.of(move3times, move2times, move1times));

        //when
        for (int i = 0; i < 3; i++) {
            raceParticipants.move();
            raceResults.recordResult(raceParticipants.getCars());
        }

        //then
        assertSoftly(softly -> {
            softly.assertThat(raceResults.getRaceResults()).hasSize(3);

            List<Map<Car, Integer>> raceResultResponse = raceResults.getRaceResults();

            softly.assertThat(raceResultResponse.get(0)).containsEntry(move3times, 1);
            softly.assertThat(raceResultResponse.get(0)).containsEntry(move2times, 1);
            softly.assertThat(raceResultResponse.get(0)).containsEntry(move1times, 1);

            softly.assertThat(raceResultResponse.get(1)).containsEntry(move3times, 2);
            softly.assertThat(raceResultResponse.get(1)).containsEntry(move2times, 2);
            softly.assertThat(raceResultResponse.get(1)).containsEntry(move1times, 1);

            softly.assertThat(raceResultResponse.get(2)).containsEntry(move3times, 3);
            softly.assertThat(raceResultResponse.get(2)).containsEntry(move2times, 2);
            softly.assertThat(raceResultResponse.get(2)).containsEntry(move1times, 1);
        });
    }

    @Nested
    class 최종_우승자를_가져온다 {
        @Test
        void 우승자가_한_명일_경우() {
            //given
            final Car move3times = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            final Car move2times = new Car("car2", new MockMovingStrategy(List.of(true, true, false)));
            final Car move1times = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            final RaceParticipants raceParticipants = new RaceParticipants(List.of(move3times, move2times, move1times));

            //when
            for (int i = 0; i < 3; i++) {
                raceParticipants.move();
                raceResults.recordResult(raceParticipants.getCars());
            }

            //then
            assertThat(raceResults.getRaceWinners()).containsExactly(move3times);
        }

        @Test
        void 우승자가_여러_명일_경우() {
            //given
            final Car move3times1 = new Car("car1", new MockMovingStrategy(List.of(true, true, true)));
            final Car move3times2 = new Car("car2", new MockMovingStrategy(List.of(true, true, true)));
            final Car move1times = new Car("car3", new MockMovingStrategy(List.of(true, false, false)));

            final RaceParticipants raceParticipants = new RaceParticipants(
                    List.of(move3times1, move3times2, move1times));

            //when
            for (int i = 0; i < 3; i++) {
                raceParticipants.move();
                raceResults.recordResult(raceParticipants.getCars());
            }

            //then
            assertThat(raceResults.getRaceWinners()).containsExactly(move3times1, move3times2);
        }
    }
}