package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

class RaceTest {
    @Test
    void createTest() {
        assertThat(new Race(Arrays.asList("A", "B", "C")).equals(new Race(Arrays.asList("A", "B", "C")))).isTrue();
    }

    @Test
    void invalidCreateTest1() {
        assertThat(new Race(Arrays.asList("A", "B", "C")).equals(new Race(Arrays.asList("D", "E", "F")))).isFalse();
    }

    @Test
    void invalidCreateTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(Arrays.asList("A"));
        });
    }

    @Test
    void invalidCreateTest3() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(Arrays.asList("A", "A"));
        });
    }

    @Test
    void getWinnersTest1() {
        Race race = new Race(Arrays.asList("A", "B", "C"), new ForceMove());
        race.startRound();
        assertThat(race.getWinners().toString()).isEqualTo(Arrays.asList("A", "B", "C").toString());
    }

    @Test
    void getWinnersTest2() {
        Race race = new Race(Arrays.asList("A", "B", "C"), new ForceStop());
        race.startRound();
        assertThat(race.getWinners().size()).isEqualTo(0);
    }
}