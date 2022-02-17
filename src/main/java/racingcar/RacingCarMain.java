package racingcar;

import racingcar.controller.RacingController;
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
        racingController.race(round);
        racingController.checkWinners();
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
