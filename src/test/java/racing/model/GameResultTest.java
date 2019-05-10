package racing.model;

import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.GameResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultTest {

    @Test
    void 챔피언이하나일때챔피언계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoo"));
        cars.add(new Car("jinwo"));
        cars.get(0).move(5);
        cars.get(0).move(5);
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        assertThat(GameResult.calculateChampions(cars)).isEqualTo(winners);
    }

    @Test
    void 챔피언이여러명일때챔피언계산() throws Exception {
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
        assertThat(new HashSet(GameResult.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
