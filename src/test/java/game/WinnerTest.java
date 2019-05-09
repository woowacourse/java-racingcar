package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Winner winner;
    List<Car> cars;

    @BeforeEach
    void setUp() {
        winner = new Winner();
        cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jason"));
        cars.add(new Car("brown"));
        cars.get(0).move(4);
    }

    @Test
    void 우승자_결과_확인() {
        boolean result = winner.checkWinner(cars, 1);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 우승자_이름_확인() {
        winner.addWinner(true, cars.get(0));
        String name = winner.getWinners().get(0);
        assertThat(name).isEqualTo("pobi");
    }
}
