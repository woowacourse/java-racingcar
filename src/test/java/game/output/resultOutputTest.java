package game.output;

import game.Car;
import game.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class resultOutputTest {

    Car car;
    Winner winner;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        winner = new Winner();
        winner.addWinner(true, car);
    }

    @Test
    void 자동차_출력_결과_확인() {
      car.move(4);
      car.move(4);
      resultOutput.result(car);
    }

    @Test
    void 최종_우승자_출력_확인() {
        resultOutput.winnersOutput(winner.getWinners());
    }
}
