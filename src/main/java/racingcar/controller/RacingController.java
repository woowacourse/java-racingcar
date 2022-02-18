package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.ui.RacingCarOutput;

import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void generateRacingCars(List<String> carNames) {
        racingService.generateCars(carNames);
    }


    public List<Car> race() {
        return racingService.raceRound();
    }

    public void checkWinners() {
        RacingCarOutput.printWinners(racingService.findWinners());
    }
}
