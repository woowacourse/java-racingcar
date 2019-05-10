package game.output;

import game.Car;
import game.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultOutputTest {

    Car car;
    Winner winner;
    List<Car> cars;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        winner = new Winner();
        cars = new ArrayList<>();
        cars.add(car);
        car.move(4);
        car.move(4);
        winner.checkWinner(cars, 2);
    }

    @Test
    void 자동차_출력_결과_확인() {
      ResultOutput.printEachGame(car);
    }

    @Test
    void 최종_우승자_출력_확인() {
        ResultOutput.printWinners(winner.getWinners());
    }
}
