package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.CarsGenerator;
import racingcar.utils.RoundNumberGenerator;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.generateRacingCars(carNameInput());
        int round = roundInput();
        RacingCarOutput.printRoundResultMessage();
        race(racingController, round);
        racingController.checkWinners();
    }

    private static void race(RacingController racingController, int round) {
        for (int i = 0; i < round; i++) {
            List<Car> progressRoundCars = racingController.race();
            RacingCarOutput.printRoundResult(progressRoundCars);
        }
    }

    public static List<String> carNameInput() {
        String userInput = RacingCarInput.userCarNameInput();
        try {
            return CarsGenerator.checkCarNames(userInput);
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printErrorMessage(e.getMessage());
            return carNameInput();
        }
    }

    public static int roundInput() {
        String roundNumberString = RacingCarInput.userRoundInput();
        try {
            return RoundNumberGenerator.toIntWithValidate(roundNumberString);
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printErrorMessage(e.getMessage());
            return roundInput();
        }
    }
}
