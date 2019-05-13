package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> carNames = new ArrayList<>(Arrays.asList("A", "B"));
        List<RoundResult> racingResult = new Race(carNames, new ForceMove()).startRace(1);
        RoundResult virtualRoundResult = new RoundResult(new ArrayList<>(
                Arrays.asList(new Car("A", 1), new Car("B", 1))
        ));
        assertThat(racingResult.equals(new ArrayList<>(Arrays.asList(virtualRoundResult)))).isTrue();
    }

    @Test
    void startRaceTest2() {
        List<String> carNames = new ArrayList<>(Arrays.asList("A", "B"));
        List<RoundResult> racingResult = new Race(carNames, new ForceMove()).startRace(1);
        RoundResult virtualRoundResult = new RoundResult(new ArrayList<>(
                Arrays.asList(new Car("A", 1), new Car("B", 2))
        ));
        assertThat(racingResult.equals(new ArrayList<>(Arrays.asList(virtualRoundResult)))).isFalse();
    }
}