package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundsTest {
    @Test
    void 기준점이상을입력시True를반환하는지() {
        assertThat(Rounds.canMove(4)).isTrue();
        assertThat(Rounds.canMove(5)).isTrue();
        assertThat(Rounds.canMove(6)).isTrue();
        assertThat(Rounds.canMove(7)).isTrue();
        assertThat(Rounds.canMove(8)).isTrue();
        assertThat(Rounds.canMove(9)).isTrue();
    }

    @Test
    void 기준점미만을입력시False를반환하는지() {
        assertThat(Rounds.canMove(0)).isFalse();
        assertThat(Rounds.canMove(1)).isFalse();
        assertThat(Rounds.canMove(2)).isFalse();
        assertThat(Rounds.canMove(3)).isFalse();
    }

    @Test
    void 챔피언이하나일때챔피언계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoon"));
        cars.add(new Car("jinwook"));
        cars.get(0).move();
        cars.get(0).move();
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        assertThat(Rounds.calculateChampions(cars)).isEqualTo(winners);
    }

    @Test
    void 챔피언이여러명일때챔피언계산() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jihoon"));
        cars.add(new Car("jinwook"));
        cars.get(0).move();
        cars.get(1).move();
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(1));
        winners.add(cars.get(0));
        HashSet<Car> winnerSet = new HashSet<>(winners);
        assertThat(new HashSet(Rounds.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
