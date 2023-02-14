package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.WinnerJudgeImpl;
import racing.domain.car.Car;

class WinnerJudgeTest {
    private WinnerJudgeImpl winnerJudge = new WinnerJudgeImpl();
    private List<Car> cars;
    private List<Car> winners;

    @BeforeEach
    void setup() {
        Car winner = new Car("dani", 1);
        Car notWinner = new Car("hihi", 0);

        cars = List.of(winner, notWinner);
    }

    @Test
    @DisplayName("반환값에 우승자가 포함되어 있는지 테스트")
    void shouldContainsWinners() {
        winners = winnerJudge.getWinner(cars);
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        Assertions.assertThat(winnerNames)
                .containsExactly("dani");
    }

    @Test
    @DisplayName("반환값에 우승자가 아닌 사람이 포함되어 있지 않은지 테스트")
    void shouldNotContainNonWinners() {
        winners = winnerJudge.getWinner(cars);
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        Assertions.assertThat(winnerNames)
                .doesNotContain("hihi");
    }
}