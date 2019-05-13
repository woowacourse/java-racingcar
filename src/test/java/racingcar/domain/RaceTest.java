package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

class RaceTest {
    @Test
    void createTest() {
        assertThat(new Race(Arrays.asList("A", "B", "C")).
                equals(new Race(Arrays.asList("A", "B", "C")))).isTrue();
    }

    @Test
    void invalidCreateTest1() {
        assertThat(new Race(Arrays.asList("A", "B", "C")).
                equals(new Race(Arrays.asList("D", "E", "F")))).isFalse();
    }

    @Test
    void invalidCreateTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(Arrays.asList("A"));
        });
    }

    @Test
    void invalidCreateTest3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(Arrays.asList("A", "A"));
        });
    }

    @Test
    void startRaceTest1() {
        Race race = new Race(Arrays.asList("A", "B"), new ForceMove());
        RacingResult racingResult1 = race.startRace(1);

        RacingResult racingResult2 = new RacingResult();
        racingResult2.addParticipant(new Car("A"));
        racingResult2.addParticipant(new Car("B"));
        racingResult2.updateResult(new Car("A"), true);
        racingResult2.updateResult(new Car("B"), true);

        assertThat(racingResult1.equals(racingResult2)).isTrue();
    }

    @Test
    void startRaceTest2() {
        Race race = new Race(Arrays.asList("A", "B"), new ForceMove());
        RacingResult racingResult1 = race.startRace(3);

        RacingResult racingResult2 = new RacingResult();
        racingResult2.addParticipant(new Car("A"));
        racingResult2.addParticipant(new Car("B"));
        racingResult2.updateResult(new Car("A"), true);
        racingResult2.updateResult(new Car("B"), true);

        assertThat(racingResult1.equals(racingResult2)).isFalse();
    }
}