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
    private MovingStrategy onlyMoveStrategy = () -> true;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        carController = new CarController(carRepository, onlyMoveStrategy);
    }

    @Test
    @DisplayName("우승자가 한명일 때")
    public void Only_One_Winner() {
        // given
        Car car1 = new Car("foo", onlyMoveStrategy);
        Car car2 = new Car("boo", onlyMoveStrategy);
        Car car3 = new Car("bar", onlyMoveStrategy);

        // when
        car1.move();
        car1.move();
        car1.move();

        car2.move();

        car3.move();
        car3.move();

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = carController.getWinners();
        
        // then
        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 여러일 때")
    public void Two_Or_More_Winners() {
        // given
        Car car1 = new Car("foo", onlyMoveStrategy);
        Car car2 = new Car("boo", onlyMoveStrategy);
        Car car3 = new Car("bar", onlyMoveStrategy);

        // when
        car1.move();
        car1.move();
        car1.move();

        car2.move();

        car3.move();
        car3.move();
        car3.move();

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = carController.getWinners();

        // then
        assertThat(winners).containsExactly(car1, car3);
    }
}
