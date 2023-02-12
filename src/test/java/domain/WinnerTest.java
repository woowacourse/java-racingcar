package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class WinnerTest {
    @Test
    void checkWinner() {
        List<String> names = List.of("aa", "bb", "cc");
        Cars cars = new Cars(names);
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        Winner winner = new Winner(cars);
        assertThat(String.join("", winner.getWinners())).isEqualTo("ff");
    }

    @Test
    void checkTwoWinners() {
        List<String> names = List.of("aa", "bb", "cc");
        Cars cars = new Cars(names);
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 8, 7));
        Winner winner = new Winner(cars);
        assertThat(String.join(",", winner.getWinners())).isEqualTo("bb,ff");
    }
}
