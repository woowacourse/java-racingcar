package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.rule.CarMoveRandomCondition;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {
    private static int TEST_MOVE_COUNT = 5;
    private RacingGame racingGame;


    @BeforeEach
    void setUp() {
        ArrayList<Car> carList = new ArrayList();
        carList.add(new Car("포비", new CarMoveRandomCondition()));
        carList.add(new Car("제이슨", new CarMoveRandomCondition()));
        carList.add(new Car("브라운", new CarMoveRandomCondition()));
        racingGame = new RacingGame(Cars.of(carList), TEST_MOVE_COUNT);
    }

    @Test
    void isEnd_모든_레이스가_끝나면_true를_반환한다() {
        for (int i = 0; i < TEST_MOVE_COUNT; i++) {
            racingGame.race();
        }

        assertTrue(racingGame.isEnd());
    }
}
