package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundsTest {
    @Test
    void 챔피언이_하나일때_챔피언계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoo"));
        cars.add(new Car("jinwo"));
        cars.get(0).move(4);
        cars.get(0).move(4);
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        assertThat(Rounds.calculateChampions(cars)).isEqualTo(winners);
    }

    @Test
    void 챔피언이_여러명일때_챔피언계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoo"));
        cars.add(new Car("jinwo"));
        cars.get(0).move(4);
        cars.get(1).move(4);
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(1));
        winners.add(cars.get(0));
        HashSet<Car> winnerSet = new HashSet<>(winners);
        assertThat(new HashSet(Rounds.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
