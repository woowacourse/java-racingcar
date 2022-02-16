package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;

public class CarControllerTest {

    private CarRepository carRepository;
    private CarController carController;
    private final InputView inputView = new InputView();

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {

        // given
        car1 = Car.builder().movingStrategy(new RandomMovingStrategy()).build();
        car2 = Car.builder().movingStrategy(new RandomMovingStrategy()).build();
        car3 = Car.builder().movingStrategy(new RandomMovingStrategy()).build();

        carRepository = new CarRepository();
        carController = new CarController(carRepository, inputView);
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
