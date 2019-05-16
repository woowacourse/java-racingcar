package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;
    RacingGameResult result;
    String outputString;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
    }

    @Test
    void getWinners() {
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();
        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        result = new RacingGameResult(cars);
        assertThat(result.getWinners()).containsOnly(car2, car3);
    }

    @Test
    void getCarsStatString() {
        result = new RacingGameResult(cars);
        outputString = "a : \nb : \nc : \n";
        assertThat(result.getCarsStatString()).isEqualTo(outputString);

        car1.moveForward();
        result = new RacingGameResult(cars);
        outputString = "a : -\nb : \nc : \n";
        assertThat(result.getCarsStatString()).isEqualTo(outputString);
    }
}