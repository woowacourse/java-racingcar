package game;

import game.output.ResultOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnerTest {
    Game game = new Game();
    Winner winner = new Winner();
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        game = new Game();
        winner = new Winner();
        cars = new ArrayList<>();

        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car mir = new Car("mir");
        int tryCount = 5;

        cars.add(pobi);
        cars.add(crong);
        cars.add(mir);

        while (tryCount-- > 0) {
            game.playOneGame(cars);
        }
    }

    @Test
    void 우승자_결정_확인() {
        winner.selectWinners(cars);
    }

    @AfterEach
    void tearDown() {
        ResultOutput.printWinners(winner.getWinners());
    }
}
