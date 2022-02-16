package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.CarsGenerator;

import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void generateRacingCars() {
        racingService.generateCars(carNameInput());
    }

    public List<String> carNameInput() {
        String userInput = RacingCarInput.userCarNameInput();
        try {
            return CarsGenerator.checkCarNames(userInput);
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printErrorMessage(e.getMessage());
            return carNameInput();
        }
    }

    public void race(final int round) {
        for (int i = 0; i < round; i++) {
            List<Car> progressRoundCars = racingService.raceRound();
            RacingCarOutput.printRoundResult(progressRoundCars);
        }
    }

    public void checkWinners() {
        RacingCarOutput.printWinners(racingService.findWinners());
    }
}
