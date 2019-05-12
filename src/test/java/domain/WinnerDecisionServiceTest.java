package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerDecisionServiceTest {
    @Test
    void decideWinnersTest() {
        GameResult gameResult = new GameResult(Arrays.asList("pobi", "crong"), 2);
        List<Car> cars = new ArrayList<>();
        List<Car> winners;

        gameResult.getCars().get(0).move(4);
        cars.add(new Car("pobi"));
        cars.get(0).move(4);

        winners = WinnerDecisionService.decideWinners(gameResult);

        for (int i = 0; i < cars.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(cars.get(i));
        }
    }
}
