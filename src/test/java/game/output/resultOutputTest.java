package game.output;

import game.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class resultOutputTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_출력_결과_확인() {
      car.move(4);
      car.move(4);
      resultOutput.result(car);
    }
}
