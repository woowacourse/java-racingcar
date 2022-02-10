package racingcar;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    @Test
    void 우승자를_선출한다_우승자가_한명인경우() {
        // given
        CarController carController = new CarController();
        Car car1 = new Car();
        Car car2 = new Car();
        carController.add(car1);
        carController.add(car2);

        // when
        car1.attemptToMove(4);
        car2.attemptToMove(3);

        // then
        assertThat(carController.findWinners()).containsExactly(car1);
    }

    @Test
    void 우승자를_선출한다_우승자가_두명인경우() {
        // given
        CarController carController = new CarController();
        Car car1 = new Car();
        Car car2 = new Car();
        carController.add(car1);
        carController.add(car2);

        // when
        car1.attemptToMove(4);
        car2.attemptToMove(4);

        // then
        assertThat(carController.findWinners()).containsExactly(car1, car2);
    }




}