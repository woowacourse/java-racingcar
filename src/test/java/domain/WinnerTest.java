package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    private final List<String> names = List.of("name1", "name2", "name3");
    private Cars cars;

    @BeforeEach()
    void init() {
        cars = new Cars(names);
    }

    @DisplayName("name1, name2, name3 각 0, 1, 2의 distance 가 예상될때 name3만 우승하는 지 알아본다")
    @Test
    void checkOneWinner() {
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinners().containsAll(List.of("name3"))).isTrue();
    }

    @DisplayName("name1, name2, name3 각 0, 1, 2의 distance 가 예상될때 name2와 name3가 공동우승하는 지 알아본다")
    @Test
    void checkTwoWinners() {
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 8, 7));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinners().containsAll(List.of("name2", "name3"))).isTrue();
    }
}
