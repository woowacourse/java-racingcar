package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {
    @Test
    void checkWinner() {
        Cars cars = new Cars("aa,bb,ff");
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        Winner winner = new Winner(cars);
        assertThat(String.join("", winner.getWinners())).isEqualTo("ff");
    }

    @Test
    void checkTwoWinners() {
        Cars cars = new Cars("aa,bb,ff");
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 8, 7));
        Winner winner = new Winner(cars);
        assertThat(String.join(",", winner.getWinners())).isEqualTo("bb,ff");
    }
}