package domain;

import racing.domain.WinnerJudgeImpl;
import racing.domain.car.Car;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerJudgeTest {
    WinnerJudgeImpl winnerJudge = new WinnerJudgeImpl();
    List<Car> cars;
    List<Car> winners;

    @BeforeEach
    void setup() {
        Car winner = new Car("dani");
        // TODO: 사용하는 입장에서 앞으로 움직이는 조건을 확인하기 어려움. Car 개선하기
        winner.moveDependingOn(9);

        Car notWinner = new Car("hihi");
        notWinner.moveDependingOn(0);

        cars = List.of(winner, notWinner);
    }

    @Test
    @DisplayName("반환값에 우승자가 포함되어 있는지 테스트")
    void shouldContainsWinners() {
        winners = winnerJudge.getWinner(cars);
        Assertions.assertThat(winners)
                .containsExactly(new Car("dani"));
    }

    @Test
    @DisplayName("반환값에 우승자가 아닌 사람이 포함되어 있지 않은지 테스트")
    void shouldNotContainNonWinners() {
        winners = winnerJudge.getWinner(cars);
        Assertions.assertThat(winners)
                .doesNotContain(new Car("hihi"));
    }
}