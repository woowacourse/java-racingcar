package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private final Cars cars = new Cars(Arrays.asList("dani", "brown", "pobi"));
    private final List<Car> carsTotal = cars.getCars();
    private final Movable winnerMovable = () -> 8;
    private final Movable loserMovable = () -> 2;

    @DisplayName("최종 우승자를 판단한다")
    @Test
    public void judgeWinners() {
        final String winner = "dani";

        carsTotal.get(0).move(winnerMovable);
        carsTotal.get(1).move(loserMovable);
        carsTotal.get(2).move(loserMovable);

        Winners winners = new Winners();

        assertThat(winners.judge(cars)).containsExactly(winner);
    }
}
