package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceTest;

class RacingGameControllerTest {

    RacingGameController racingGameController;
    CarRepository carRepository;
    RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        racingGameService = new RacingGameService(carRepository, new RacingGameServiceTest.MockRandomNumberGenerator());
        racingGameController = new RacingGameController(carRepository, racingGameService);
    }

    @Test
    public void 자동차_이름_입력() {
        racingGameController.inputCarNames("pobi,crong,honux");
        assertThat(carRepository.findAll()).contains(Car.from("pobi"), Car.from("crong"), Car.from("honux"));
    }
}