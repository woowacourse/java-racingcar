package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.controller.CarController;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class CarControllerTest {

    private CarController carController;
    private Car car1;
    private Car car2;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        carController = new CarController();
        car1 = new Car(new CarName("칙촉"));
        car2 = new Car(new CarName("어썸오"));

        cars = Arrays.asList(car1, car2);
    }

    @Test
    void 우승자를_선출한다_우승자가_한명인경우() {
        car1.attemptToMove(4);
        car2.attemptToMove(3);

        assertThat(carController.findWinners(cars)).containsExactly(car1);
    }

    @Test
    void 우승자를_선출한다_우승자가_두명인경우() {
        car1.attemptToMove(4);
        car2.attemptToMove(4);

        assertThat(carController.findWinners(cars)).containsExactly(car1, car2);
    }
}
