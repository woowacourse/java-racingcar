package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    private CarRepository carRepository;
    private CarController carController;
    private final MovingStrategy onlyMoveStrategy = () -> true;

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {

        // given
        car1 = Car.createFixedMovingCar("foo");
        car2 = Car.createFixedMovingCar("boo");
        car3 = Car.createFixedMovingCar("bar");

        carRepository = new CarRepository();
        carController = new CarController(carRepository);
    }

    @Test
    @DisplayName("우승자가 한명일 때")
    public void Only_One_Winner() {

        // when
        car1.move(3);
        car2.move(1);
        car3.move(2);

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = carController.getWinners();
        
        // then
        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 여러명일 때")
    public void Two_Or_More_Winners() {

        // when
        car1.move(3);
        car2.move(1);
        car3.move(3);

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = carController.getWinners();

        // then
        assertThat(winners).containsExactly(car1, car3);
    }
}
