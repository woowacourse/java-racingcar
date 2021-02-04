package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RacingRepositoryTest {

    @DisplayName("우승자 결과 테스트 한 명")
    @Test
    void singleWinnerResult() {
        List<Car> cars = new ArrayList<Car>();

        Car winner = new Car("pobi");
        Car loser = new Car("crong");

        winner.goForward();

        cars.add(winner);
        cars.add(loser);

        Assertions.assertThat(cars.size()).isEqualTo(1);
        Assertions.assertThat(cars.get(0)).isEqualTo(winner);
    }

    @DisplayName("우승자 결과 테스트 여러명")
    @Test
    void multiWinnerResult() {
        List<Car> cars = new ArrayList<Car>();
        List<Car> winners = new ArrayList<Car>();

        Car winner1 = new Car("pobi");
        Car winner2 = new Car("poci");
        Car winner3 = new Car("podi");
        Car loser = new Car("crong");

        winner1.goForward();
        winner2.goForward();
        winner3.goForward();

        cars.add(winner1);
        cars.add(winner2);
        cars.add(winner3);
        cars.add(loser);

        winners.add(winner1);
        winners.add(winner2);
        winners.add(winner3);

        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertTrue(cars.containsAll(winners));
    }
}
