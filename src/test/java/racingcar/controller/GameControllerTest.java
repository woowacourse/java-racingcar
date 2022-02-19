package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    CarRepository carRepository;
    GameController gameController;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        gameController = new GameController(carRepository);
    }


    @Test
    @DisplayName("우승자가 한명일 때")
    public void Only_One_Winner() {
        // given
        Car car1 = Car.carBuilder().setCarName("foo").build();
        Car car2 = Car.carBuilder().setCarName("boo").build();
        Car car3 = Car.carBuilder().setCarName("bar").build();

        // when
        car1.moveOrHold(true);
        car1.moveOrHold(true);
        car1.moveOrHold(true);

        car2.moveOrHold(true);

        car3.moveOrHold(true);
        car3.moveOrHold(true);

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = gameController.getWinners();

        // then
        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 여럿일 때")
    public void Two_Or_More_Winners() {
        // given
        Car car1 = Car.carBuilder().setCarName("foo").build();
        Car car2 = Car.carBuilder().setCarName("boo").build();
        Car car3 = Car.carBuilder().setCarName("bar").build();

        // when
        car1.moveOrHold(true);
        car1.moveOrHold(true);
        car1.moveOrHold(true);

        car2.moveOrHold(true);

        car3.moveOrHold(true);
        car3.moveOrHold(true);
        car3.moveOrHold(true);

        carRepository.addCars(List.of(car1, car2, car3));
        List<Car> winners = gameController.getWinners();

        // then
        assertThat(winners).containsExactly(car1, car3);
    }
}
