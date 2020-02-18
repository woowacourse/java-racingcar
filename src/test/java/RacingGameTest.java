import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private static final List<Car> carList = new ArrayList<>();
    private static Cars cars;
    private static RacingGame racingGame;

    static {
        carList.clear();
        carList.add(new Car("pobi", 4));
        carList.add(new Car("crong", 7));
        carList.add(new Car("honux", 3));
        cars = new Cars(carList);
        racingGame = new RacingGame(cars);
    }

    @Test
    void Cars_이동_테스트() {
        racingGame.moveCars(new MoveGenerator());
        Winners winners = cars.makeWinners(8);

        Assertions.assertThat(winners.getWinners()).containsExactly("crong");
    }

    @Test
    void Cars_정지_테스트() {
        racingGame.moveCars(new StopGenerator());
        Winners winners = cars.makeWinners(7);

        Assertions.assertThat(winners.getWinners()).containsExactly("crong");
    }
}