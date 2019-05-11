package racinggame.view;

import racinggame.Car;
import racinggame.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class resultOutputTest {

    Car car;
    List<Car> cars = new ArrayList<>();
    Winner winner;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        car.move(4);
        car.move(4);
        cars.add(car);
        winner = new Winner();
    }

    @Test
    void 자동차_출력_결과_확인() {
      resultOutput.eachGameOutput(car);
    }

    @Test
    void 최종_우승자_출력_확인() {
        winner.checkWinner(cars, 2);
        resultOutput.winnersOutput(winner.getWinners());
    }
}
