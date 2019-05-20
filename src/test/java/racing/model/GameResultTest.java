package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultTest {
    GameResult gameResult;

    @BeforeEach
    void initGameResult() {
        gameResult = new GameResult();
    }

    @Test
    void 챔피언이_하나일_때_챔피언_계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoo"));
        cars.add(new Car("jinwo"));
        cars.get(0).move(5);
        cars.get(0).move(5);
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        assertThat(gameResult.calculateChampions(cars)).isEqualTo(winners);
    }

    @Test
    void 챔피언이_여러_명일_때_챔피언_계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoo"));
        cars.add(new Car("jinwo"));
        cars.get(0).move(5);
        cars.get(1).move(5);
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(1));
        winners.add(cars.get(0));
        HashSet<Car> winnerSet = new HashSet<>(winners);
        assertThat(new HashSet(gameResult.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
