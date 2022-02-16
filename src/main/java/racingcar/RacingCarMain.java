package racingcar;

import racingcar.controller.RacingController;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.RoundNumberGenerator;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.generateRacingCars();
        int round = RoundNumberGenerator.roundInput();
        RacingCarOutput.printRoundResultMessage();
        racingController.race(round);
        racingController.checkWinners();
    }
}
